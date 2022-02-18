package service;

import java.util.ArrayList;
import java.util.List;
import scheme.SkierVertical;
import scheme.Vertical;

public class SkierService {
  public static SkierVertical getTotalVerticals(String skierID, String resort, String season) {
    List<Vertical> verticals = new ArrayList<>();
    verticals.add(new Vertical("string", 0));
    return new SkierVertical(verticals);
  }

  public static int getSkiDayVerticalForASkier(String resortID, String seasonID, String dayID, String skierID) {
    return 34507;
  }

  public static void addSkiDayVerticalForASkier(String resortID, String seasonID, String dayID, String skierID) {
    return;
  }
}
