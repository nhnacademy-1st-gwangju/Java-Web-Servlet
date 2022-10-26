package com.nhnacademy.nhnmart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProcessingController implements Command {
    private String initId;
    private String initPassword;
    private String money;

    public LoginProcessingController(String initId, String initPassword, String money) {
        this.initId = initId;
        this.initPassword = initPassword;
        this.money = money;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if (initId.equals(id) && initPassword.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            session.setAttribute("money", money);

            request.setAttribute("view", "redirect:/login.do");
            return "redirect:/login.do";
        } else {
            request.setAttribute("view", "/loginForm.jsp");
            return "/loginForm.jsp";
        }
    }
}
