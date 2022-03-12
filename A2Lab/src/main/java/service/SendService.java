package service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class SendService {

  private final static String QUEUE_NAME = "threadExQ";
  private final static int NUM_MESSAGES_PER_THREAD =10;

  public static void main(String[] args) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("34.221.50.57");
    Connection connection = factory.newConnection();
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        try {
          Channel channel = connection.createChannel();
          channel.queueDeclare(QUEUE_NAME, true, false, false, null);
          for (int i = 0; i < NUM_MESSAGES_PER_THREAD; i++) {
            String message = "Here's a message " + Integer.toString(i);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
          }
          channel.close();
          System.out.println(" [All Messages  Sent '" );
        } catch (IOException | TimeoutException e) {
          e.printStackTrace();
        }
      }
    };

    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    t1.start();
    t2.start();

    t1.join();
    t2.join();

    connection.close();
  }
}
