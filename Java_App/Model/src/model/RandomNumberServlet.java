package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "RandomNumberServlet", urlPatterns = { "/random-number" })
public class RandomNumberServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
      System.out.println("###########Inside");
    NumberBean bean = 
      RanUtils.randomNum(request.getParameter("range"));
    request.setAttribute("randomNum", bean);
    String address = "random-num.jspx";
    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}