import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Client {

  final static private int NUMTHREADS = 100;

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch completed = new CountDownLatch(NUMTHREADS);
    AtomicInteger counter = new AtomicInteger(0);
    long cur = System.currentTimeMillis();
    for (int i = 0; i < NUMTHREADS; i++) {
      new Thread(new RequestThread(completed, counter)).start();
    }

    completed.await();
    System.out.println(
        "It cost the client " + (System.currentTimeMillis() - cur) + " to finish the requests.");
    System.out.println("Value should be equal to " + NUMTHREADS + " It is: " + counter.get());
  }
}
