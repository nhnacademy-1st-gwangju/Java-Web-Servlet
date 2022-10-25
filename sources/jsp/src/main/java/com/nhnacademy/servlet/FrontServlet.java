package com.nhnacademy.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {

    private static final String REDIRECT_PREFIX = "redirect:";

    // 모든 HTTP 메소드에 대해 처리하기 위해 service를 사용함
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try {
            // 실제 요청 처리할 Servlet 결정.
            // ex.) /student/register, /student/view
//            String processingServletPath = resolveServlet(req.getServletPath());
            Command command = resolveServlet(req.getServletPath());

            // 실제 요청을 처리할 Servlet으로 요청을 전달하여 처리 결과를 include시킴. (제어권을 다시 가져올 목적)
//            RequestDispatcher rd = req.getRequestDispatcher(processingServletPath);
//            rd.include(req, resp);

            String view = command.execute(req, resp);

            // 실제 요청을 처리한 Servlet이 `view`라는 request 속성 값으로 view를 전달해 줌.
//            String view = (String) req.getAttribute("view");
            if (view.startsWith(REDIRECT_PREFIX)) {
                // `redirect:`로 시작하면 redirect 처리.
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                // redirect 아니면 JSP에게 view 처리를 위임하여 그 결과를 include시킴.

                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception ex) {
            // 에러가 발생한 경우는 error page로 지정된 `/error.jsp`에게 view 처리를 위임.
            log.error("", ex);
            req.setAttribute("exception", ex);
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    // 요청 URL에 따라 실제 요청을 처리할 Servlet 결정. -> 기존 String return에서 Command로 변경
    // Servlet일 필요가 없어져서 Command로 변경했기 때문
    private Command resolveServlet(String servletPath) {
        Command command = null;
//        String processingServletPath = null;

        if ("/student/registerForm.do".equals(servletPath)) {
//            processingServletPath = "/student/registerForm";
            command = new StudentRegisterController();
        } else if ("/student/register.do".equals(servletPath)) {
//            processingServletPath = "/student/register";
            command = new StudentRegisterServlet();
        } else if ("/student/view.do".equals(servletPath)) {
//            processingServletPath = "/student/view";
            command = new StudentViewServlet();
        }

//        return processingServletPath;

        return command;
    }
}
