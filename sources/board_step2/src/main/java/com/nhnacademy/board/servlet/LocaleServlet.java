package com.nhnacademy.board.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "localeServlet", urlPatterns = "/change-lang")
public class LocaleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        String lang = servletContext.getAttribute("lang").toString();

        if (lang.equals("ko")) {
            servletContext.setAttribute("lang", "en");
        } else {
            servletContext.setAttribute("lang", "ko");
        }

        RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
        rd.forward(req, resp);
    }
}
