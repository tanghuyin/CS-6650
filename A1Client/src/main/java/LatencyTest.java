import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.api.SkiersApi;
import io.swagger.client.model.LiftRide;

public class LatencyTest {

  public static void main(String[] args) {
    ApiClient client = new ApiClient();
    client.setBasePath("http://35.165.36.243:8080");
    SkiersApi skiersApi = new SkiersApi(client);
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      LiftRide liftRide = new LiftRide().liftID(10).time(10).waitTime(10);
      try {
        skiersApi.writeNewLiftRide(liftRide, 1, "2019", "345", 10);
      } catch (ApiException e) {
        e.printStackTrace();
      }
    }
    System.out.println((System.currentTimeMillis() - start) / 10000.0); // latency = 14.125 ms
  }
}
