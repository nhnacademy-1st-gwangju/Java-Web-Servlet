package com.nhnacademy.servlet;

import com.nhnacademy.domain.Student;
import com.nhnacademy.domain.StudentRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

//@WebServlet(name = "studentViewServlet", urlPatterns = "/student/view")
// extends HttpServlet
public class StudentViewServlet implements Command {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletContext servletContext = req.getServletContext();
//        StudentRepository studentRepository = (StudentRepository) servletContext.getAttribute("studentRepository");
//
//        String id = req.getParameter("id");
//
//        Student student = studentRepository.get(id);
//        if (Objects.isNull(student)) {
//            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
//        } else {
//            // jsp 에서 해당 객체를 참조할 수 있게 등록한다.
//            req.setAttribute("student", student);
//
////            resp.setContentType("text/html");
////            resp.setCharacterEncoding("UTF-8");
////
////            RequestDispatcher rd = req.getRequestDispatcher("/studentView.jsp");
////            rd.forward(req, resp);
//            req.setAttribute("view", "/studentView.jsp");
//        }
//    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = request.getServletContext();
        StudentRepository studentRepository = (StudentRepository) servletContext.getAttribute("studentRepository");

        String id = request.getParameter("id");

        Student student = studentRepository.get(id);
        if (Objects.isNull(student)) {
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return "/404.jsp";
        } else {
            // jsp 에서 해당 객체를 참조할 수 있게 등록한다.
            request.setAttribute("student", student);
            return "/studentView.jsp";
        }
    }
}
