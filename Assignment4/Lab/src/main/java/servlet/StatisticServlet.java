package servlet;

import com.google.gson.Gson;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import scheme.APIStats;
import service.StatisticService;
import util.Response;

@WebServlet(name = "servlet.StatisticServlet", value = "/statistics")
public class StatisticServlet extends HttpServlet {

  private final Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = request.getRequestURI();
    Pattern statisticsUrl = Pattern.compile("/statistics/?");
    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    if (statisticsUrl.matcher(url).matches()) {
      APIStats apiStats = StatisticService.getAPIPerformanceStats();
      response.setStatus(HttpServletResponse.SC_OK);
      out.print(gson.toJson(apiStats));
    } else {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      out.print(gson.toJson(new Response("string")));
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}
