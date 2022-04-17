package servlet;

import com.google.gson.Gson;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import scheme.Resort;
import scheme.ResortList;
import scheme.ResortSkiers;
import scheme.SeasonList;
import service.ResortService;
import util.Response;
import util.ServletHelper;

@WebServlet(name = "servlet.ResortServlet", value = "/resorts/*")
public class ResortServlet extends HttpServlet {

  private final Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = request.getRequestURI();
    Pattern listOfSkiResortsUrl = Pattern.compile("/resorts/?");
    Pattern listOfSeasonsForAResortUrl = Pattern.compile("/resorts/[0-9]+/seasons/?");
    Pattern numberOfUniqueSkiersAtResortSeasonDay = Pattern.compile("/resorts/[0-9]+/seasons/[0-9]+/day/[0-9]+/skiers/?");
    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    if (listOfSkiResortsUrl.matcher(url).matches()) {
      ResortList resorts = ResortService.getListOfSkiResorts();
      response.setStatus(HttpServletResponse.SC_OK);
      out.print(gson.toJson(resorts));
    } else if (listOfSeasonsForAResortUrl.matcher(url).matches()) {
      String[] params = url.split("/");
      String resortID = params[2];
      if (ResortService.isValidResortID(resortID)) {
        SeasonList seasons = ResortService.getListOfSeasonsByResortID(resortID);
        response.setStatus(HttpServletResponse.SC_OK);
        out.print(gson.toJson(seasons));
      } else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        out.print(gson.toJson(new Response("string")));
      }
    } else if (numberOfUniqueSkiersAtResortSeasonDay.matcher(url).matches()) {
      String[] params = url.split("/");
      String resortID = params[2];
      String seasonID = params[4];
      String dayID = params[6];
      if (ResortService.isValidResortID(resortID)) {
        ResortSkiers resortSkiers = ResortService.getNumberOfUniqueSkiersByResortSeasonDay(resortID, seasonID, dayID);
        response.setStatus(HttpServletResponse.SC_OK);
        out.print(gson.toJson(resortSkiers));
      } else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        out.print(gson.toJson(new Response("string")));
      }
    } else {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      out.print(gson.toJson(new Response("string")));
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = request.getRequestURI();
    Pattern addNewSeasonForAResortUrl = Pattern.compile("/resorts/[0-9]+/seasons/?");
    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    if (addNewSeasonForAResortUrl.matcher(url).matches()) {
      String[] params = url.split("/");
      String resortID = params[2];
      if (!ResortService.isResortExist(resortID)) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        out.print(gson.toJson(new Response("string")));
        return;
      }
      String body = ServletHelper.getBody(request);
      ResortService.addNewSeasonForAResortUrl(resortID);
      response.setStatus(HttpServletResponse.SC_CREATED);
    }
  }
}
