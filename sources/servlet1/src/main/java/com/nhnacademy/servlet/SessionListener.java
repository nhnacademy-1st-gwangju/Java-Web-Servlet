package com.nhnacademy.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Slf4j
public class SessionListener implements HttpSessionListener {

    private int count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("session={}", ++count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("session={}", --count);
    }
}
