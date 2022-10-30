package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.Post;
import com.nhnacademy.board.domain.PostRepository;
import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.domain.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.NoSuchElementException;
import java.util.Objects;

public class PostInfoController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        PostRepository postRepository = (PostRepository) request.getServletContext().getAttribute("postRepository");
        UserRepository userRepository = (UserRepository) request.getServletContext().getAttribute("userRepository");
        long id = Long.parseLong(request.getParameter("id"));

        Post post = postRepository.getPost(id);
        if (Objects.isNull(post)) {
            request.setAttribute("error", "해당하는 게시글을 찾을 수 없습니다.");
            return "/404.jsp";
        } else {
            User user = userRepository.getUsers().stream()
                    .filter(u -> u.getName().equals(post.getWriterUserId()))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
            request.setAttribute("postWriterId", user.getId());
            request.setAttribute("findPost", post);
            return "/postDetail.jsp";
        }
    }
}
