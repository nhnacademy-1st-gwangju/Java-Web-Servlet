package com.nhnacademy.servlet;

import com.nhnacademy.domain.Student;
import com.nhnacademy.domain.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "studentRegisterServlet", urlPatterns = "/student/register")
// extends HttpServlet
public class StudentRegisterServlet implements Command {

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        req.setCharacterEncoding("UTF-8");
//
//        Student student = new Student(
//                req.getParameter("id"),
//                req.getParameter("name"),
//                req.getParameter("gender"),
//                Integer.parseInt(req.getParameter("age")));
//
//        // 구현 클래스가 아닌 인터페이스를 참조하라 (Repository 구현체가 바뀔 수 있기 때문)
//        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
//        studentRepository.addStudent(student);
//
////        resp.sendRedirect("/student/view?id=" + student.getId());
//        req.setAttribute("view", "redirect:/student/view.do?id=" + student.getId());
//    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Student student = new Student(
                request.getParameter("id"),
                request.getParameter("name"),
                request.getParameter("gender"),
                Integer.parseInt(request.getParameter("age")));

        // 구현 클래스가 아닌 인터페이스를 참조하라 (Repository 구현체가 바뀔 수 있기 때문)
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        studentRepository.addStudent(student);

        return "redirect:/student/view.do?id=" + student.getId();
    }
}
