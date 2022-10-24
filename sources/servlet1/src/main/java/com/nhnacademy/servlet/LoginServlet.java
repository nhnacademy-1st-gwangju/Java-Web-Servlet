package com.nhnacademy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (Objects.isNull(session)) {
            resp.sendRedirect("/login.html");
        } else {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println("로그인 성공");
            resp.getWriter().println(session.getAttribute("id").toString() + "<br />");
            resp.getWriter().println("<a href=\"/logout\">로그아웃</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        String initId = getServletConfig().getInitParameter("id");
        String initPassword = getServletConfig().getInitParameter("password");

        if (initId.equals(id) && initPassword.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/login.html");
        }

    }
}
