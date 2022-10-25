package com.nhnacademy.nhnmart.servlet;

import com.nhnacademy.nhnmart.app.Food;
import com.nhnacademy.nhnmart.app.FoodStand;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        String onion = servletContext.getInitParameter("onion");
        String egg = servletContext.getInitParameter("egg");
        String greenOnion = servletContext.getInitParameter("greenOnion");
        String apple = servletContext.getInitParameter("apple");

        String[] splitOnion = onion.split(" ");
        String[] splitEgg = egg.split(" ");
        String[] splitGreenOnion = greenOnion.split(" ");
        String[] splitApple = apple.split(" ");

        FoodStand foodStand = new FoodStand();

        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food(splitOnion[0], Integer.parseInt(splitOnion[1])));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food(splitEgg[0], Integer.parseInt(splitEgg[1])));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food(splitGreenOnion[0], Integer.parseInt(splitGreenOnion[1])));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food(splitApple[0], Integer.parseInt(splitApple[1])));
        }

        servletContext.setAttribute("foodStand", foodStand);

        servletContext.setAttribute("initOnionCount", Integer.parseInt(splitOnion[2]));
        servletContext.setAttribute("initEggCount", Integer.parseInt(splitEgg[2]));
        servletContext.setAttribute("initGreenOnionCount", Integer.parseInt(splitGreenOnion[2]));
        servletContext.setAttribute("initAppleCount", Integer.parseInt(splitApple[2]));

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("<a href=\"/foods\">상품 목록</a>");
    }
}
