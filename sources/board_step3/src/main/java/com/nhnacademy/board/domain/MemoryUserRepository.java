package com.nhnacademy.board.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryUserRepository implements UserRepository {

    private Map<String, User> userMap;

    @Autowired
    public MemoryUserRepository() {
        this.userMap = new ConcurrentHashMap<>();
    }

    @Override
    public void add(User user) {
        if (!userMap.containsKey(user.getId())) {
            userMap.put(user.getId(), user);
        }
    }

    @Override
    public void modify(User user) {
        if (userMap.containsKey(user.getId())) {
            userMap.replace(user.getId(), user);
        }
    }

    @Override
    public User remove(String id) {
        return userMap.remove(id);
    }

    @Override
    public User getUser(String id) {
        return userMap.getOrDefault(id, null);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }
}
