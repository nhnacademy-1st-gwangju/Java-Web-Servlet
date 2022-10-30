package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.domain.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class UserInfoController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserRepository repository = (UserRepository) request.getServletContext().getAttribute("userRepository");
        String id = request.getParameter("id");

        User user = repository.getUser(id);
        if (Objects.isNull(user)) {
            request.setAttribute("error", "해당하는 사용자를 찾을 수 없습니다.");
            return "/404.jsp";
        } else {
            request.setAttribute("findUser", user);
            return "/userDetail.jsp";
        }
    }
}
