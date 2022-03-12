import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;
import schema.SkiDayVerticalOuterClass.SkiDayVertical;

public class Consumer {
  public static void main(String[] args) throws IOException, TimeoutException {
    ConcurrentHashMap<String, List<SkiDayVertical>> map = new ConcurrentHashMap<>();
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("172.31.5.232");
    Connection connection = factory.newConnection();

    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        try {
          Channel channel = connection.createChannel();
          channel.queueDeclare("client1", true, false, false, null);
          System.out.println("wait for messages");

          DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            SkiDayVertical skiDayVertical = SkiDayVertical.parseFrom(delivery.getBody());
            map.computeIfAbsent(skiDayVertical.getSkierID(), k -> Collections.synchronizedList(new ArrayList<SkiDayVertical>())).add(skiDayVertical);
          };

          channel.basicConsume("client1", true, deliverCallback, consumerTag -> {});
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    };

    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);

    t1.start();
    t2.start();
  }
}
