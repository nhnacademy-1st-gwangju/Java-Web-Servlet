package com.nhnacademy.nhnmart.servlet;

import com.nhnacademy.nhnmart.controller.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {

    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        Command command = resolveCommand(req.getServletPath(), req.getMethod());

        String view = command.execute(req, resp);

        if (view.startsWith(REDIRECT_PREFIX)) {
            resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(view);
            rd.include(req, resp);
        }
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;

        if ("/cart.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new CartListController();
        } else if ("/cart.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new CartUpdateController();
        } else if ("/foods.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new FoodListController();
        } else if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new LoginProcessingController("songs4805", "12345", "20000");
        } else if ("/login.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LoginResultController();
        } else if ("/logout.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LogoutProcessingController();
        } else if ("/change-lang.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
//            command = "/change-lang";
        } else if ("/pay.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new PayProcessingController();
        }

        return command;
    }
}
