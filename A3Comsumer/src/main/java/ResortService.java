import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import redis.clients.jedis.Pipeline;
import schema.SkiDayVerticalOuterClass.SkiDayVertical;

public class ResortService {
  public static void main(String[] args) throws IOException, TimeoutException {

    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("172.31.5.232");
    String EXCHANGE_NAME = "logs";
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();
    channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
    String queueName = channel.queueDeclare().getQueue();
    channel.queueBind(queueName, EXCHANGE_NAME, "");


    Runnable runnable = () -> {
      try {
        RedisClient redisClient = new RedisClient("localhost");
        Pipeline p = redisClient.getPipeline();
        Channel c = connection.createChannel();
        c.queueBind(queueName, EXCHANGE_NAME, "");
        c.basicQos(2);
        System.out.println("wait for messages");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
          SkiDayVertical skiDayVertical = SkiDayVertical.parseFrom(delivery.getBody());
          String skierID = skiDayVertical.getSkierID();
          String dayID = skiDayVertical.getDayID();
          String resortID = skiDayVertical.getResortID();
          int liftID = skiDayVertical.getLiftID();
          int time = skiDayVertical.getTime();
          redisClient.addSkierToResortByDay(resortID, dayID, skierID);
          redisClient.increaseRideByLiftAndDay(dayID + "_dayID", "l:" + String.valueOf(liftID));
          redisClient.increaseRideByHourAndDay(dayID + "_dayID", "h:" + String.valueOf(time / 60));
          p.sync();
          c.basicAck(delivery.getEnvelope().getDeliveryTag(), true);
        };
        c.basicConsume(queueName, false, deliverCallback, consumerTag -> {});
      } catch (IOException e) {
        e.printStackTrace();
      }
    };
    for (int i = 0; i < 40; i++) {
      Thread t = new Thread(runnable);
      t.start();
    }
  }
}
