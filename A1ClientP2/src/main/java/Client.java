import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huyin
 */
public class Client {
  private static final Logger logger = LoggerFactory.getLogger(Client.class);
  static AtomicInteger failureCounter = new AtomicInteger(0);

  public static void main(String[] args) throws InterruptedException {

    int numOfThreads = 256;
    int numOfSkiers = 20000;
    int numOfSkiLifts = 40;
    int meanNumberOfSkiLiftsSkierRidesEachDay = 10;

    double PHASE_2_THRESHOLD = 0.2;
    double PHASE_3_THRESHOLD = 0.2;
    BlockingQueue<List<RequestRecord>> queue = new LinkedBlockingDeque<>();

    logger.info("========Client Start========");
    logger.info("Number of Skiers: {}", numOfSkiers);
    logger.info("Number of Lifts: {}", numOfSkiLifts);
    logger.info("Number of Threads: {}", numOfThreads);
    // phase 1: startup phase, launch numOfThreads / 4 threads, and each thread have numOfSkiers / (numOfThreads / 4) skiers
    int numOfRuns = 20;
    int phase1Threads = numOfThreads / 4;
    int skiersPerThread = (int)Math.ceil((double)numOfSkiers / phase1Threads);
    int requestCount = (int)(0.2 * numOfRuns * skiersPerThread);
    int startTime = 1;
    int endTime = 90;
    CountDownLatch allCountDown1 = new CountDownLatch(phase1Threads);
    CountDownLatch phase1CountDown = new CountDownLatch((int)(phase1Threads * PHASE_2_THRESHOLD));
    AtomicInteger counter1 = new AtomicInteger(0);
    long start = System.currentTimeMillis();
    logger.info("========Phase 1 Start========");
    logger.info("Number of Threads In Phase 1: {}", phase1Threads);
    logger.info("Skiers Per Thread: {}", skiersPerThread);
    logger.info("Request Per Thread: {}", requestCount);
    logger.info("Time From {} to {}.", startTime, endTime);
    for (int i = 0; i < phase1Threads; i++) {
      new Thread(new LiftRideThread(skiersPerThread * i + 1,
          Math.min(skiersPerThread * (i + 1), numOfSkiers), startTime, endTime, numOfSkiLifts, requestCount, phase1CountDown, allCountDown1, counter1, queue)).start();
    }
    phase1CountDown.await();
    logger.info("========Phase 1 Finish========");

    // phase 2 peak phase
    int phase2Threads = numOfThreads;
    skiersPerThread = (int)Math.ceil((double)numOfSkiers / phase2Threads);
    requestCount = (int)(0.6 * numOfRuns * skiersPerThread);
    startTime = 91;
    endTime = 360;
    CountDownLatch allCountDown2 = new CountDownLatch(phase2Threads);
    CountDownLatch phase2CountDown = new CountDownLatch((int)(phase2Threads * PHASE_3_THRESHOLD));
    AtomicInteger counter2 = new AtomicInteger(0);
    logger.info("========Phase 2 Start========");
    logger.info("Number of Threads In Phase 2: " + phase2Threads);
    logger.info("Skiers Per Thread: " + skiersPerThread);
    logger.info("Request Per Thread: " + requestCount);
    logger.info("Time From {} to {}.", startTime, endTime);
    for (int i = 0; i < phase2Threads; i++) {
      new Thread(new LiftRideThread(skiersPerThread * i + 1,
          Math.min(skiersPerThread * (i + 1), numOfSkiers), startTime, endTime, numOfSkiLifts, requestCount, phase2CountDown, allCountDown2, counter2, queue)).start();
    }
    phase2CountDown.await();
    logger.info("========Phase 2 Finish========");

    int phase3Threads = (int)(0.1 * numOfThreads);
    skiersPerThread = (int)Math.ceil((double)numOfSkiers / phase3Threads);
    requestCount = (int)(0.1 * numOfRuns * skiersPerThread);
    startTime = 361;
    endTime = 420;
    CountDownLatch allCountDown3 = new CountDownLatch(phase3Threads);
    CountDownLatch phase3CountDown = new CountDownLatch((int)(phase3Threads * PHASE_3_THRESHOLD));
    AtomicInteger counter3 = new AtomicInteger(0);
    logger.info("========Phase 3 Start========");
    logger.info("Number of Threads In Phase 3: {}", phase3Threads);
    logger.info("Skiers Per Thread: {}", skiersPerThread);
    logger.info("Request Per Thread: {}", requestCount);
    logger.info("Time From {} to {}.", startTime, endTime);
    for (int i = 0; i < phase3Threads; i++) {
      new Thread(new LiftRideThread(skiersPerThread * i + 1,
          Math.min(skiersPerThread * (i + 1), numOfSkiers), startTime, endTime, numOfSkiLifts, requestCount, phase3CountDown, allCountDown3, counter3, queue)).start();
    }
    logger.info("========Phase 3 Finish========");
    allCountDown1.await();
    allCountDown2.await();
    allCountDown3.await();
    logger.info("========Report========");
    long time = System.currentTimeMillis() - start;
    int totalRequest = counter1.get() + counter2.get() + counter3.get();
    logger.info("Time Spent: {}ms", time);
    logger.info("Request Send: {}", totalRequest);
    logger.info("Number of unsuccessful requests: {}", Client.failureCounter.get());
    logger.info("Total throughput: {} req/s", 1000 * totalRequest / (double)time);

    MyCSVWriter.createEmptyCSV("result256.csv");
    MyCSVWriter.writeFiles("result256.csv", queue);
  }
}
