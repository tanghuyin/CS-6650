package util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class ChannelFactory extends BasePooledObjectFactory<Channel> {
  private Connection connection = null;

  public ChannelFactory() {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("172.31.5.232");
    try {
      connection = factory.newConnection();
    } catch (IOException | TimeoutException e) {
      e.printStackTrace();
    }
  }
  @Override
  public Channel create() throws Exception {
    return connection.createChannel();
  }

  @Override
  public PooledObject<Channel> wrap(Channel channel) {
    return new DefaultPooledObject<>(channel);
  }

  @Override
  public void destroyObject(PooledObject<Channel> p) throws Exception {
    super.destroyObject(p);
    p.getObject().close();
  }

  public void close() {
    try {
      this.connection.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
