package com.nhnacademy.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class TestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.error("doFilter() called");

        chain.doFilter(request, response);

        log.error("chain.doFilter(request, response) called()");
    }
}
