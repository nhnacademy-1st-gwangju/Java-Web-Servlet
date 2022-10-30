package com.nhnacademy.board.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LoginCountListener implements HttpSessionListener {

    private int loginUserCount;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.setAttribute("loginUserCount", ++loginUserCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.setAttribute("loginUserCount", --loginUserCount);
    }
}