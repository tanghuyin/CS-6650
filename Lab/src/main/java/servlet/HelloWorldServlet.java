package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servlet.HelloWorldServlet", value = "/hello")
public class HelloWorldServlet extends HttpServlet {

  private String msg;

  @Override
  public void init() throws ServletException {
    msg = "Hello World";
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    PrintWriter out = response.getWriter();
    out.println("<h1>" + msg + "</h1>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

  @Override
  public void destroy() {
    // nothing to do here
  }
}
