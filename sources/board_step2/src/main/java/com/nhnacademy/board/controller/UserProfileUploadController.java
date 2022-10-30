package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.domain.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class UserProfileUploadController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        UserRepository repository = (UserRepository) request.getServletContext().getAttribute("userRepository");
        String id = request.getParameter("id");
        User user = repository.getUser(id);

        request.setAttribute("editUser", user);

        return "/userProfile.jsp";
    }
}
