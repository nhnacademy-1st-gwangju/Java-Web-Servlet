package com.nhnacademy.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class TestServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("init() called");
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("service() called");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        log.info("destroy() called");
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("---TestServlet.doGet---");
        String title = getServletConfig().getInitParameter("title");
        String name = getServletConfig().getInitParameter("name");
        resp.getWriter().println("hello " + title + " " + name);

        Util.test(getServletContext());
        resp.getWriter().println(getServletContext().getAttribute("counter"));
    }
}
