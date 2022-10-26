package com.nhnacademy.nhnmart.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartListController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = request.getServletContext();

        int cartOnion = Integer.parseInt(servletContext.getAttribute("cartOnion").toString());
        int cartEgg = Integer.parseInt(servletContext.getAttribute("cartEgg").toString());
        int cartGreenOnion = Integer.parseInt(servletContext.getAttribute("cartGreenOnion").toString());
        int cartApple = Integer.parseInt(servletContext.getAttribute("cartApple").toString());
        int sum = cartOnion * 1000 + cartEgg * 2000 + cartGreenOnion * 500 + cartApple * 2000;

        request.setAttribute("sum", sum);

        return "/cartView.jsp";
    }
}
