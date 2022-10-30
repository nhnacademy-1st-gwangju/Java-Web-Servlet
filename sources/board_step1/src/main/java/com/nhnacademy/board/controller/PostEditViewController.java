package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.Post;
import com.nhnacademy.board.domain.PostRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostEditViewController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        PostRepository repository = (PostRepository) request.getServletContext().getAttribute("postRepository");
        Long id = Long.parseLong(request.getParameter("id"));
        Post post = repository.getPost(id);

        request.setAttribute("editPost", post);
        return "/postEdit.jsp";
    }
}
