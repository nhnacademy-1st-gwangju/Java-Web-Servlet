package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.Post;
import com.nhnacademy.board.domain.PostRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PostListController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = request.getServletContext();
        PostRepository postRepository = (PostRepository) servletContext.getAttribute("postRepository");
        List<Post> posts = postRepository.getPosts();

        if (posts.isEmpty()) {
            request.setAttribute("error", "게시글 목록을 찾을 수 없습니다.");
            return "/404.jsp";
        } else {
            request.setAttribute("posts", posts);
            return "/postList.jsp";
        }
    }
}
