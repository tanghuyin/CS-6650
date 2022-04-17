import java.util.Set;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

public class RedisClient {
  private Jedis jedis = null;
  private Pipeline p = null;

  public RedisClient(String host) {
    JedisPool pool = new JedisPool(host, 6379);
    try {
      jedis = pool.getResource();
      p = jedis.pipelined();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Pipeline getPipeline() {
    return p;
  }

  /**
   * Increase the field value 1
   * @param key skierID
   * @param field
   */
  public void increaseFieldValueByKey(String key, String field) {
    increaseFieldValueByKey(key, field, 1);
  }

  // “For skier N, how many days have they skied this season?”
  public void addDayToSkier(String skierID, String dayID) {
    p.sadd("s:" + skierID, dayID);
  }

  // For skier N, show me the lifts they rode on each ski day
  public void addLiftToSkier(String skierID, String dayID, int liftID) {
    p.sadd("s:" + skierID + ";d:" + dayID, String.valueOf(liftID));
  }

  public long getNumberOfDaysThisSeasonBySkierID(String skierID) {
    return jedis.scard(skierID);
  }

  public Set<String> getLiftsUsedBySkierIDAndDayID(String skierID, String dayID) {
    return jedis.smembers("s:" + skierID + ";d:" + dayID);
  }

  // For skier N, what are the vertical totals for each ski day?” (calculate vertical as liftID*10)
  public void increaseVerticalForSkierOnDayAndSeason(String resortID, String seasonID, String skierID, String dayID, int value) {
    p.incrBy("s:" + skierID + ";d:" + dayID + ";r:" + resortID + ";s:" + seasonID + "_v", value);
  }

  // For skier N, what are the vertical totals for each ski day?” (calculate vertical as liftID*10)
  public void increaseVerticalForSkierOnSeason(String resortID, String seasonID, String skierID, int value) {
    p.incrBy("s:" + skierID + ";r:" + resortID + ";s:" + seasonID + "_v", value);
  }

  public void increaseFieldValueByKey(String key, String field, int value) {
    p.hincrBy(key, field, value);
  }

  // How many unique skiers visited resort X on day N?
  public void addSkierToResortByDayAndSeason(String resortID, String dayID, String skierID, String seasonID) {
    p.sadd("r:" + resortID + ";d:" + dayID + ";s:" + seasonID, skierID);
  }

  // How many rides on lift N happened on day N?
  public void increaseRideByLiftAndDay(String dayID, String liftID) {
    increaseFieldValueByKey(dayID, liftID, 1);
  }

  // On day N, show me how many lift rides took place in each hour of the ski day
  public void increaseRideByHourAndDay(String dayID, String hour) {
    increaseFieldValueByKey(dayID, hour, 1);
  }
}
