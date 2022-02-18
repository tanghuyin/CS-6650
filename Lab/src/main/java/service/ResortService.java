package service;

import java.util.ArrayList;
import java.util.List;
import scheme.Resort;
import scheme.ResortList;
import scheme.ResortSkiers;
import scheme.SeasonList;

public class ResortService {

  public static ResortList getListOfSkiResorts() {
    List<Resort> resorts = new ArrayList<>();
    resorts.add(new Resort("string", 0));
    return new ResortList(resorts);
  }

  public static SeasonList getListOfSeasonsByResortID(String resortID) {
    List<String> list = new ArrayList<>();
    list.add("string");
    return new SeasonList(list);
  }


  public static ResortSkiers getNumberOfUniqueSkiersByResortSeasonDay(String resortID, String seasonID, String dayID) {
    ResortSkiers resortSkiers = new ResortSkiers("Mission Ridge", 78999);
    return resortSkiers;
  }

  public static void addNewSeasonForAResortUrl(String resortID) {

  }

  public static boolean isValidResortID(String resortID) {
    return true;
  }

  public static boolean isResortExist(String resortID) {
    return true;
  }
}
