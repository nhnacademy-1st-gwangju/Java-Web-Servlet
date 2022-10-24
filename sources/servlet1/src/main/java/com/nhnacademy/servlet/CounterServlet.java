package com.nhnacademy.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CounterServlet extends HttpServlet {

    private int count;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        count = Integer.parseInt(config.getInitParameter("counter"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(count++);
        resp.getWriter().println(getServletContext().getInitParameter("url"));

        Util.test(getServletContext());
        resp.getWriter().println(getServletContext().getAttribute("counter"));
    }
}
