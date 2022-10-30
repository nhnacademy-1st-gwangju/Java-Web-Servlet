package com.nhnacademy.board.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "exclude-urls", value = "/\n" +
                                                "/index.jsp\n" +
                                                "/login.do\n" +
                                                "/change-lang\n" +
                                                "/loginForm.jsp")
})
public class LoginCheckFilter implements Filter {
    private Set<String> excludeUrls = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urls = filterConfig.getInitParameter("exclude-urls");
        excludeUrls = Arrays.stream(urls.split("\n"))
                .map(String::trim)
                .collect(Collectors.toSet());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);

        if (Objects.isNull(session)) {
            // 세션이 없으면
            if (excludeUrls.contains(((HttpServletRequest) request).getRequestURI())) {
                chain.doFilter(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/loginForm.jsp");
                rd.forward(request, response);
            }
        } else {
            // 세션이 있으면
            chain.doFilter(request, response);
        }
    }
}
