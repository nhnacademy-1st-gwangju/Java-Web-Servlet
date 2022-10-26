package com.nhnacademy.nhnmart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class LoginResultController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if (Objects.isNull(session)) {
            return "redirect:/loginForm.jsp";
        } else {
            return "redirect:/loginSuccess.jsp";
        }
    }
}
