package servlet;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import org.apache.commons.pool2.impl.GenericObjectPool;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import scheme.LiftRide;
import scheme.SkierVertical;
import service.SkierService;
import util.ChannelFactory;
import util.Response;
import util.ServletHelper;

@WebServlet(name = "servlet.SkierServlet", value = "/skiers/*")
public class SkierServlet extends HttpServlet {

  private final Gson gson = new Gson();
  private GenericObjectPool<Channel> channelPool;
  private ChannelFactory channelFactory;
  private JedisPool jedisPool;

  @Override
  public void init() throws ServletException {
    super.init();
    channelFactory = new ChannelFactory();
    jedisPool = new JedisPool("localhost", 6379);
    channelPool = new GenericObjectPool<>(channelFactory);
    channelPool.setMaxTotal(50);
    channelPool.setBlockWhenExhausted(true);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = request.getRequestURI();
    Pattern getSkiDayVerticalForASkier = Pattern.compile("/skiers/[0-9]+/seasons/[0-9]+/days/[0-9]+/skiers/[0-9]+/?");
    Pattern getTotalVertical = Pattern.compile("/skiers/[0-9]+/vertical/?");
    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    if (getTotalVertical.matcher(url).matches()) {
      String[] params = url.split("/");
      String skierID = params[2];
      String resort = request.getParameter("resort");
      String season = request.getParameter("season");
      SkierVertical skierVertical = SkierService.getTotalVerticals(skierID, resort, season);
      try (Jedis jedis = jedisPool.getResource()) {
        //TODO:
      }
      response.setStatus(HttpServletResponse.SC_OK);
      out.print(gson.toJson(skierVertical));
    } else if (getSkiDayVerticalForASkier.matcher(url).matches()) {
      String[] params = url.split("/");
      String resortID = params[2];
      String seasonID = params[4];
      String dayID = params[6];
      String skierID = params[8];
      int total = SkierService.getSkiDayVerticalForASkier(resortID, seasonID, dayID, skierID);
      try (Jedis jedis = jedisPool.getResource()) {
        //TODO:
      }
      response.setStatus(HttpServletResponse.SC_OK);
      out.print(total);
    } else {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      out.print(gson.toJson(new Response("string")));
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = request.getRequestURI();
    Pattern addNewLiftRideForTheSkier = Pattern.compile("/skiers/[0-9]+/seasons/[0-9]+/days/[0-9]+/skiers/[0-9]+/?");
    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    String body = ServletHelper.getBody(request);
    LiftRide ride = gson.fromJson(body, LiftRide.class);
    if (addNewLiftRideForTheSkier.matcher(url).matches()) {
      String[] params = url.split("/");
      String resortID = params[2];
      String seasonID = params[4];
      String dayID = params[6];
      String skierID = params[8];
      SkierService.addSkiDayVerticalForASkier(resortID, seasonID, dayID, skierID, ride, channelPool);
      response.setStatus(HttpServletResponse.SC_CREATED);
    } else {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      out.print(gson.toJson(new Response("string")));
    }
  }

  private boolean isUrlValid(String[] urlPath) {
    // TODO: validate the request url path according to the API spec
    // urlPath  = "/1/seasons/2019/day/1/skier/123"
    // urlParts = [, 1, seasons, 2019, day, 1, skier, 123]
    return true;
  }

  @Override
  public void destroy() {
    channelPool.close();
    channelFactory.close();
  }
}
