package com.nhnacademy.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "studentRegisterFormServlet", urlPatterns = "/student/registerForm")
public class StudentRegisterController implements Command {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // view만 지정
//        req.setAttribute("view", "/studentRegister.jsp");
//    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/studentRegister.jsp";
    }
}
