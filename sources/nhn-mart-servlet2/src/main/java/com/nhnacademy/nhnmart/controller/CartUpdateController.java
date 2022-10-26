package com.nhnacademy.nhnmart.controller;

import com.nhnacademy.nhnmart.domain.Food;
import com.nhnacademy.nhnmart.domain.FoodStand;
import com.nhnacademy.nhnmart.exception.AmountException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartUpdateController implements Command {

    private int initOnionCount;
    private int initEggCount;
    private int initGreenOnionCount;
    private int initAppleCount;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String[] carts = request.getParameterValues("cart");

        ServletContext servletContext = request.getServletContext();

        Integer onionCount = Integer.parseInt(carts[0]);
        Integer eggCount = Integer.parseInt(carts[1]);
        Integer greenOnionCount = Integer.parseInt(carts[2]);
        Integer appleCount = Integer.parseInt(carts[3]);

        String onion = servletContext.getInitParameter("onion");
        String egg = servletContext.getInitParameter("egg");
        String greenOnion = servletContext.getInitParameter("greenOnion");
        String apple = servletContext.getInitParameter("apple");

        String[] splitOnion = onion.split(" ");
        String[] splitEgg = egg.split(" ");
        String[] splitGreenOnion = greenOnion.split(" ");
        String[] splitApple = apple.split(" ");


        initOnionCount = Integer.parseInt(servletContext.getAttribute("initOnionCount").toString());
        initEggCount = Integer.parseInt(servletContext.getAttribute("initEggCount").toString());
        initGreenOnionCount = Integer.parseInt(servletContext.getAttribute("initGreenOnionCount").toString());
        initAppleCount = Integer.parseInt(servletContext.getAttribute("initAppleCount").toString());

        if (initOnionCount < onionCount || initEggCount < eggCount || initGreenOnionCount < greenOnionCount || initAppleCount < appleCount) {
            throw new AmountException("수량이 부족합니다.");
        } else {
            FoodStand foodStand = (FoodStand) servletContext.getAttribute("foodStand");

            foodStand.delete();
            renew(onionCount, splitOnion, foodStand);
            renew(eggCount, splitEgg, foodStand);
            renew(greenOnionCount, splitGreenOnion, foodStand);
            renew(appleCount, splitApple, foodStand);

            servletContext.setAttribute("foodStand", foodStand);

            servletContext.setAttribute("cartOnion", onionCount);
            servletContext.setAttribute("cartEgg", eggCount);
            servletContext.setAttribute("cartGreenOnion", greenOnionCount);
            servletContext.setAttribute("cartApple", appleCount);

            servletContext.setAttribute("initOnionCount", initOnionCount - onionCount);
            servletContext.setAttribute("initEggCount", initEggCount - eggCount);
            servletContext.setAttribute("initGreenOnionCount", initGreenOnionCount - greenOnionCount);
            servletContext.setAttribute("initAppleCount", initAppleCount - appleCount);


            return "redirect:/cart.do";
        }
    }
    
    private void renew(Integer foodCount, String[] splitFood, FoodStand foodStand) {
        for (int i = 0; i < initOnionCount - foodCount; i++) {
            foodStand.add(new Food(splitFood[0], Integer.parseInt(splitFood[1])));
        }
    }
}
