package com.nhnacademy.board.servlet;

import com.nhnacademy.board.controller.*;

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

        if ("/users/view.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new UserListController();
        } else if ("/userInfo.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new UserInfoController();
        } else if ("/users/register.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new UserRegisterController();
        } else if ("/users/edit.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new UserEditViewController();
        } else if ("/users/edit.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new UserEditController();
        } else if ("/users/profile.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new UserProfileUploadController();
        } else if ("/users/delete.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new UserDeleteController();
        }

        else if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new LoginProcessingController();
        } else if ("/login.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LoginResultController();
        } else if ("/logout.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LogoutProcessingController();
        }

        else if ("/posts/view.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new PostListController();
        } else if ("/postInfo.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new PostInfoController();
        } else if ("/posts/register.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new PostRegisterController();
        } else if ("/posts/edit.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new PostEditViewController();
        } else if ("/posts/edit.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new PostEditController();
        } else if ("/posts/delete.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new PostDeleteController();
        }

        return command;
    }
}
