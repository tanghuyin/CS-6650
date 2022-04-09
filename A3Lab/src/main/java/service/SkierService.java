package service;

import com.rabbitmq.client.Channel;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.pool2.impl.GenericObjectPool;
import scheme.LiftRide;
import scheme.SkiDayVerticalOuterClass.SkiDayVertical;
import scheme.SkierVertical;
import scheme.Vertical;

public class SkierService {

  public static SkierVertical getTotalVerticals(String skierID, String resort, String season) {
    List<Vertical> verticals = new ArrayList<>();
    verticals.add(new Vertical("string", 0));
    return new SkierVertical(verticals);
  }

  public static int getSkiDayVerticalForASkier(String resortID, String seasonID, String dayID,
      String skierID) {
    return 34507;
  }

  public static void addSkiDayVerticalForASkier(String resortID, String seasonID, String dayID,
      String skierID, LiftRide ride, GenericObjectPool<Channel> channelPool) {
    SkiDayVertical skiDayVertical = SkiDayVertical.newBuilder().setResortID(resortID)
        .setSeasonID(seasonID).setDayID(dayID).setSkierID(skierID).setLiftID(ride.getLiftID())
        .setTime(ride.getTime()).setWaitTime(ride.getWaitTime()).build();
    String QUEUE_NAME = "client1";
    String EXCHANGE_NAME = "logs";
    try {
      Channel channel = channelPool.borrowObject();
      // channel.queueDeclare(QUEUE_NAME, true, false, false, null);
      channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
      channel.basicPublish(EXCHANGE_NAME, "", null, skiDayVertical.toByteArray());
      channelPool.returnObject(channel);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
