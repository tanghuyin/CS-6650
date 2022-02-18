import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.SkiersApi;
import io.swagger.client.model.LiftRide;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huyin
 */
public class LiftRideThread implements Runnable {

  private ApiClient client;
  private int startSkierID;
  private int endSkierID;
  private int startTime;
  private int endTime;
  private int numOfSkiLifts;
  private int requestCount;
  private CountDownLatch countDownLatch;
  private CountDownLatch countDownLatchAll;
  private AtomicInteger count;
  List<RequestRecord> records;
  BlockingQueue<List<RequestRecord>> writingQueue;

  public LiftRideThread(int startSkierID, int endSkierID, int startTime, int endTime,
      int numOfSkiLifts,
      int requestCount,
      CountDownLatch countDownLatch,
      CountDownLatch countDownLatchAll,
      AtomicInteger count,
      BlockingQueue<List<RequestRecord>> writingQueue) {
    this.startSkierID = startSkierID;
    this.endSkierID = endSkierID;
    if (this.endSkierID < this.startSkierID) {
      this.endSkierID = this.startSkierID;
    }
    this.startTime = startTime;
    this.endTime = endTime;
    this.numOfSkiLifts = numOfSkiLifts;
    this.requestCount = requestCount;
    this.count = count;
    this.client = new ApiClient();
    this.countDownLatchAll = countDownLatchAll;
    this.countDownLatch = countDownLatch;
    this.records = new ArrayList<>();
    this.writingQueue = writingQueue;
    this.client.setBasePath("http://35.165.36.243:8080");
  }

  @Override
  public void run() {
    int skierID = ThreadLocalRandom.current()
        .nextInt(startSkierID, endSkierID + 1); // [origin, bound)
    int liftID = ThreadLocalRandom.current().nextInt(1, numOfSkiLifts + 1);
    int time = ThreadLocalRandom.current().nextInt(startTime, endTime + 1);
    int waitTime = ThreadLocalRandom.current().nextInt(0, 10 + 1);
    SkiersApi skiersApi = new SkiersApi(client);

    for (int i = 0; i < requestCount; i++) {
      LiftRide liftRide = new LiftRide().liftID(liftID).time(time).waitTime(waitTime);
      try {
        long startTime = System.nanoTime();
        skiersApi.writeNewLiftRide(liftRide, 1, "2019", "345", skierID);
        long latency = System.nanoTime() - startTime;
        RequestRecord record = new RequestRecord(startTime, "POST", latency / 1000000, 201);
        records.add(record);
        this.count.incrementAndGet();
      } catch (ApiException e) {
        Client.failureCounter.incrementAndGet();
        e.printStackTrace();
      }
    }
    countDownLatchAll.countDown();
    countDownLatch.countDown();
    writingQueue.add(records);
  }
}
