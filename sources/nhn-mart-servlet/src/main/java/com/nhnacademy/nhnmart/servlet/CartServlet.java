package com.nhnacademy.nhnmart.servlet;

import com.nhnacademy.nhnmart.app.Food;
import com.nhnacademy.nhnmart.app.FoodStand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CartServlet extends HttpServlet {

    private int initOnionCount;
    private int initEggCount;
    private int initGreenOnionCount;
    private int initAppleCount;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (Objects.isNull(session)) {
            resp.sendRedirect("/loginForm.html");
        } else {
            int cartOnion = Integer.parseInt(getServletContext().getAttribute("cartOnion").toString());
            int cartEgg = Integer.parseInt(getServletContext().getAttribute("cartEgg").toString());
            int cartGreenOnion = Integer.parseInt(getServletContext().getAttribute("cartGreenOnion").toString());
            int cartApple = Integer.parseInt(getServletContext().getAttribute("cartApple").toString());

            int sum = cartOnion * 1000 + cartEgg * 2000 + cartGreenOnion * 500 + cartApple * 2000;


            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println("<body>");

            resp.getWriter().println("<p>장바구니에 담긴 상품 목록: 양파 " + cartOnion + "개, 계란 " + cartEgg + "개, 파 " + cartGreenOnion + "개, 사과 " + cartApple + "개</p><br/>");
            resp.getWriter().println("<p>전체 금액: " + sum + "</p><br/>");

            resp.getWriter().println("<a href=\"/foods\">상품 목록</a>");

            resp.getWriter().println("</body>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (Objects.isNull(session)) {
            resp.sendRedirect("/loginForm.html");
        } else {
            String[] carts = req.getParameterValues("cart");

            Integer onionCount = Integer.parseInt(carts[0]);
            Integer eggCount = Integer.parseInt(carts[1]);
            Integer greenOnionCount = Integer.parseInt(carts[2]);
            Integer appleCount = Integer.parseInt(carts[3]);

            String onion = getServletContext().getInitParameter("onion");
            String egg = getServletContext().getInitParameter("egg");
            String greenOnion = getServletContext().getInitParameter("greenOnion");
            String apple = getServletContext().getInitParameter("apple");

            String[] splitOnion = onion.split(" ");
            String[] splitEgg = egg.split(" ");
            String[] splitGreenOnion = greenOnion.split(" ");
            String[] splitApple = apple.split(" ");


            initOnionCount = Integer.parseInt(getServletContext().getAttribute("initOnionCount").toString());
            initEggCount = Integer.parseInt(getServletContext().getAttribute("initEggCount").toString());
            initGreenOnionCount = Integer.parseInt(getServletContext().getAttribute("initGreenOnionCount").toString());
            initAppleCount = Integer.parseInt(getServletContext().getAttribute("initAppleCount").toString());

            if (initOnionCount < onionCount || initEggCount < eggCount || initGreenOnionCount < greenOnionCount || initAppleCount < appleCount) {
                // 수량보다 많이 주문하면 되돌아가기
                resp.sendRedirect("/foods");
            } else {
                FoodStand foodStand = (FoodStand) getServletContext().getAttribute("foodStand");

                ArrayList<Food> foods = foodStand.getFoods();
                foods.clear();
                for (int i = 0; i < initOnionCount-onionCount; i++) {
                    foodStand.add(new Food(splitOnion[0], Integer.parseInt(splitOnion[1])));
                }

                for (int i = 0; i < initEggCount-eggCount; i++) {
                    foodStand.add(new Food(splitEgg[0], Integer.parseInt(splitEgg[1])));
                }

                for (int i = 0; i < initGreenOnionCount-greenOnionCount; i++) {
                    foodStand.add(new Food(splitGreenOnion[0], Integer.parseInt(splitGreenOnion[1])));
                }

                for (int i = 0; i < initAppleCount-appleCount; i++) {
                    foodStand.add(new Food(splitApple[0], Integer.parseInt(splitApple[1])));
                }

                getServletContext().setAttribute("foodStand", foodStand);

                getServletContext().setAttribute("cartOnion", onionCount);
                getServletContext().setAttribute("cartEgg", eggCount);
                getServletContext().setAttribute("cartGreenOnion", greenOnionCount);
                getServletContext().setAttribute("cartApple", appleCount);

                getServletContext().setAttribute("initOnionCount", initOnionCount-onionCount);
                getServletContext().setAttribute("initEggCount", initEggCount-eggCount);
                getServletContext().setAttribute("initGreenOnionCount", initGreenOnionCount-greenOnionCount);
                getServletContext().setAttribute("initAppleCount", initAppleCount-appleCount);

                resp.sendRedirect("/cart");
            }
        }
    }
}
