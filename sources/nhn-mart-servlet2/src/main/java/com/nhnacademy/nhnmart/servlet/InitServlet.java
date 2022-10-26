package com.nhnacademy.nhnmart.servlet;

import com.nhnacademy.nhnmart.domain.Food;
import com.nhnacademy.nhnmart.domain.FoodStand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "initServlet", urlPatterns = "/init")
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

        initFoodStand(splitOnion, foodStand);
        initFoodStand(splitEgg, foodStand);
        initFoodStand(splitGreenOnion, foodStand);
        initFoodStand(splitApple, foodStand);

        servletContext.setAttribute("foodStand", foodStand);

        servletContext.setAttribute("initOnionCount", Integer.parseInt(splitOnion[2]));
        servletContext.setAttribute("initEggCount", Integer.parseInt(splitEgg[2]));
        servletContext.setAttribute("initGreenOnionCount", Integer.parseInt(splitGreenOnion[2]));
        servletContext.setAttribute("initAppleCount", Integer.parseInt(splitApple[2]));

        servletContext.setAttribute("money", 20000);

        servletContext.setAttribute("lang", "ko");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        RequestDispatcher rd = req.getRequestDispatcher("/initResult.jsp");
        rd.forward(req, resp);
    }

    private void initFoodStand(String[] splitFood, FoodStand foodStand) {
        for (int i = 0; i < Integer.parseInt(splitFood[2]); i++) {
            foodStand.add(new Food(splitFood[0], Integer.parseInt(splitFood[1])));
        }
    }
}
