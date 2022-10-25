package com.nhnacademy.nhnmart.servlet;

import com.nhnacademy.nhnmart.app.FoodStand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FoodServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FoodStand foodStand = (FoodStand) getServletContext().getAttribute("foodStand");

        long onionCount = foodStand.getFoods().stream()
                .filter(f -> f.getName().equals("양파"))
                .count();

        long eggCount = foodStand.getFoods().stream()
                .filter(f -> f.getName().equals("계란"))
                .count();

        long greenOnionCount = foodStand.getFoods().stream()
                .filter(f -> f.getName().equals("파"))
                .count();

        long appleCount = foodStand.getFoods().stream()
                .filter(f -> f.getName().equals("사과"))
                .count();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().println("<body>");

        resp.getWriter().println("<h3>현재 상품 재고</h3>");
        resp.getWriter().println("양파: " + onionCount + "개(1000원)<br/>");
        resp.getWriter().println("계란: " + eggCount + "판(5000원)<br/>");
        resp.getWriter().println("파: " + greenOnionCount + "개(500원)<br/>");
        resp.getWriter().println("사과: " + appleCount + "개(2000원)<br/>");
        resp.getWriter().println("<br/>");
        resp.getWriter().println("<br/>");

        resp.getWriter().println("<form method=\"post\" action=\"/cart\">");
        resp.getWriter().println("양파: <input type=\"text\" name=\"cart\"><br/>");
        resp.getWriter().println("계란: <input type=\"text\" name=\"cart\"><br/>");
        resp.getWriter().println("파: <input type=\"text\" name=\"cart\"><br/>");
        resp.getWriter().println("사과: <input type=\"text\" name=\"cart\"><br/>");
        resp.getWriter().println("<input type=\"submit\" value=\"장바구니 담기\">");
        resp.getWriter().println("</form>");
        resp.getWriter().println("</body>");
    }
}
