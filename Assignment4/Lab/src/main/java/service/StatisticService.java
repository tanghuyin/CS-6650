package service;

import java.util.ArrayList;
import java.util.List;
import scheme.APIStats;
import scheme.EndPointStat;

public class StatisticService {

  public static APIStats getAPIPerformanceStats() {
    List<EndPointStat> endPointStats = new ArrayList<>();
    endPointStats.add(new EndPointStat("/resorts", "GET", 11, 198));
    return new APIStats(endPointStats);
  }
}
