package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.PostRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostDeleteController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        PostRepository repository = (PostRepository) request.getServletContext().getAttribute("postRepository");
        repository.remove(id);

        return "redirect:/posts/view.do";
    }
}
