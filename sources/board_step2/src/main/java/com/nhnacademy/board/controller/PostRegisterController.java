package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.ConcretePost;
import com.nhnacademy.board.domain.PostRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class PostRegisterController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        ConcretePost post = new ConcretePost();

        PostRepository postRepository = (PostRepository) request.getServletContext().getAttribute("postRepository");

        request.setCharacterEncoding("utf-8");

        post.setTitle(request.getParameter("title"));
        post.setContent(request.getParameter("content"));
        post.setWriterUserId(request.getParameter("writer"));

        long postId = postRepository.register(post);
        post.setId(postId);

        return "redirect:/posts/view.do";
    }
}
