package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.domain.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserEditController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserRepository repository = (UserRepository) request.getServletContext().getAttribute("userRepository");
        String id = request.getParameter("id");
        User user = repository.getUser(id);

        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));

        repository.modify(user);

        return "redirect:/users/view.do";
    }
}
