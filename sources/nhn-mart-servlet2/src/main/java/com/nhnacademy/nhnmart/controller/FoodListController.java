package com.nhnacademy.nhnmart.controller;

import com.nhnacademy.nhnmart.domain.FoodStand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FoodListController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        FoodStand foodStand = (FoodStand) request.getServletContext().getAttribute("foodStand");

        request.setAttribute("onionCount", foodStand.count("양파"));
        request.setAttribute("eggCount", foodStand.count("계란"));
        request.setAttribute("greenOnionCount", foodStand.count("파"));
        request.setAttribute("appleCount", foodStand.count("사과"));

        return "/foodView.jsp";
    }
}
