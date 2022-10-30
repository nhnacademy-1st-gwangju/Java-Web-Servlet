package com.nhnacademy.board.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "counterFilter", urlPatterns = {"/users/view.do", "/userInfo.do", "/posts/view.do", "/postInfo.do"})
public class CounterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletContext servletContext = request.getServletContext();
        int counter = Integer.parseInt(servletContext.getAttribute("counter").toString());
        servletContext.setAttribute("counter", ++counter);

        chain.doFilter(request, response);
    }
}
