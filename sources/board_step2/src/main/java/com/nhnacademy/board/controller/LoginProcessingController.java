package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.domain.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProcessingController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserRepository userRepository = (UserRepository) request.getServletContext().getAttribute("userRepository");
        User user = userRepository.getUser(request.getParameter("id"));
        String initId = user.getId();
        String initPassword = user.getPassword();

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if (initId.equals(id) && initPassword.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            session.setAttribute("userName", user.getName());

            request.setAttribute("view", "redirect:/login.do");
            return "redirect:/login.do";
        } else {
            request.setAttribute("view", "/loginForm.jsp");
            return "/loginForm.jsp";
        }
    }
}
