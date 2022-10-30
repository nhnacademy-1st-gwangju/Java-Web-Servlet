package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        UserRepository repository = (UserRepository) request.getServletContext().getAttribute("userRepository");
        repository.remove(id);

        return "redirect:/users/view.do";
    }
}
