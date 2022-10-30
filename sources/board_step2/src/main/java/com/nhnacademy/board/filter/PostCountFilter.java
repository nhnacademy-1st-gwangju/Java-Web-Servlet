package com.nhnacademy.board.filter;

import com.nhnacademy.board.domain.Post;
import com.nhnacademy.board.domain.PostRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "postCountFilter", urlPatterns = "/postInfo.do")
public class PostCountFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PostRepository repository = (PostRepository) request.getServletContext().getAttribute("postRepository");
        long id = Long.parseLong(request.getParameter("id"));

        Post post = repository.getPost(id);
        post.increaseViewCount();
        repository.modify(post);

        chain.doFilter(request, response);
    }
}
