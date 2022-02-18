/**
 * @author huyin
 */
public class RequestRecord {
  long startTime;
  String method;
  long latency;
  int responseCode;

  public RequestRecord(long startTime, String method, long latency, int responseCode) {
    this.startTime = startTime;
    this.method = method;
    this.latency = latency;
    this.responseCode = responseCode;
  }
}
