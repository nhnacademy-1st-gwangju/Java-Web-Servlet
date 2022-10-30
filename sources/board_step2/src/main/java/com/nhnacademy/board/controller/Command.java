package com.nhnacademy.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException;
}
