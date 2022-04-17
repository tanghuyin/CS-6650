package scheme;

public class EndPointStat {

  private String URL;
  private String operation;
  private int mean;
  private int max;

  public EndPointStat(String URL, String operation, int mean, int max) {
    this.URL = URL;
    this.operation = operation;
    this.mean = mean;
    this.max = max;
  }
}
