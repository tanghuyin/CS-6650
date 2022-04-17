import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

public class RequestThread implements Runnable {

  private CountDownLatch countDownLatch;
  private AtomicInteger counter;

  public RequestThread(CountDownLatch countDownLatch, AtomicInteger counter) {
    this.countDownLatch = countDownLatch;
    this.counter = counter;
  }

  @Override
  public void run() {
    HttpClient client = new HttpClient();
    HttpMethod method = new GetMethod("http://localhost:8080/lab/hello");
    try {
      int statusCode = client.executeMethod(method);
      if (statusCode != HttpStatus.SC_OK) {
        System.err.println("Method failed: " + method.getStatusLine());
      }
      byte[] responseBody = method.getResponseBody();
      // System.out.println(new String(responseBody));
      method.releaseConnection();
    } catch (IOException e) {
      e.printStackTrace();
    }
    countDownLatch.countDown();
    counter.incrementAndGet();
  }
}
