package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.ConcreteUser;
import com.nhnacademy.board.domain.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegisterController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        ConcreteUser user = new ConcreteUser();
        user.setId(request.getParameter("id"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
//        user.setProfileFileName(request.getParameter("profile"));

        UserRepository repository = (UserRepository) request.getServletContext().getAttribute("userRepository");
        repository.add(user);

        return "redirect:/users/view.do";
    }
}
