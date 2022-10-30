package com.nhnacademy.board.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository {
    void add(User user);
    void modify(User user);
    User remove(String id);
    User getUser(String id);
    List<User> getUsers();

}
