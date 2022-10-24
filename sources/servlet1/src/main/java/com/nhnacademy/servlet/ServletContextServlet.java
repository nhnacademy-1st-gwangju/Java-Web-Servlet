package com.nhnacademy.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();

        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter out = resp.getWriter();

        try {
            out.println(servletContext.getContextPath());
            out.println(servletContext.getMajorVersion());
            out.println(servletContext.getMinorVersion());
            out.println(servletContext.getEffectiveMajorVersion());
            out.println(servletContext.getEffectiveMinorVersion());
            out.println(servletContext.getRealPath("/servletcontext"));
        } catch (Exception e) {
            log(e + "");
        }

        Util.test(getServletContext());
        resp.getWriter().println(getServletContext().getAttribute("counter"));
    }
}
