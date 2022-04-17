package scheme;

import java.util.ArrayList;
import java.util.List;

public class APIStats {
  private List<EndPointStat> endPointStats = new ArrayList<>();

  public APIStats(List<EndPointStat> endPointStats) {
    this.endPointStats = endPointStats;
  }
}
