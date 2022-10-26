package com.nhnacademy.nhnmart.controller;

import com.nhnacademy.nhnmart.exception.NotEnoughMoneyException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayProcessingController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = request.getServletContext();
        String[] pays = request.getParameterValues("pay");

        int money = Integer.parseInt(servletContext.getAttribute("money").toString());

        int payResult = money - Integer.parseInt(pays[4]);
        if (payResult < 0) {
            throw new NotEnoughMoneyException("잔액이 부족합니다.");
        } else {
            servletContext.setAttribute("money", payResult);

            request.setAttribute("sum", Integer.parseInt(pays[4]));
            request.setAttribute("payResult", payResult);
            return "/payResultView.jsp";
        }

    }
}
