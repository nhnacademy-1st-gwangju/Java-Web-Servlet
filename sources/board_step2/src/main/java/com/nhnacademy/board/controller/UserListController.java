package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.domain.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserListController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = request.getServletContext();
        UserRepository repository = (UserRepository) servletContext.getAttribute("userRepository");
        List<User> users = repository.getUsers();

        if (users.isEmpty()) {
            request.setAttribute("error", "사용자 목록을 찾을 수 없습니다.");
            return "/404.jsp";
        } else {
            request.setAttribute("users", users);
            return "/userList.jsp";
        }
    }
}
