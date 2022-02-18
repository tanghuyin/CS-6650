package servlet;

import com.google.gson.Gson;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import scheme.SkierVertical;
import service.SkierService;
import util.Response;

@WebServlet(name = "servlet.SkierServlet", value = "/skiers/*")
public class SkierServlet extends HttpServlet {

  private final Gson gson = new Gson();

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
      response.setStatus(HttpServletResponse.SC_OK);
      out.print(gson.toJson(skierVertical));
    } else if (getSkiDayVerticalForASkier.matcher(url).matches()) {
      String[] params = url.split("/");
      String resortID = params[2];
      String seasonID = params[4];
      String dayID = params[6];
      String skierID = params[8];
      int total = SkierService.getSkiDayVerticalForASkier(resortID, seasonID, dayID, skierID);
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
    if (addNewLiftRideForTheSkier.matcher(url).matches()) {
      String[] params = url.split("/");
      String resortID = params[2];
      String seasonID = params[4];
      String dayID = params[6];
      String skierID = params[8];
      SkierService.addSkiDayVerticalForASkier(resortID, seasonID, dayID, skierID);
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
}
