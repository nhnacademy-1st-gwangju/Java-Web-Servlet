package com.nhnacademy.board.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class JsonUserRepository implements UserRepository {

    private List<User> userList = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void add(User user) {
        try {
            if (userList.contains(user)) {
                throw new IllegalArgumentException("중복");
            } else {
                userList.add(user);
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                mapper.writeValue(Paths.get("users.json").toFile(), userList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(User user) {
        User findUser = userList.stream().filter(u -> u.getId().equals(user.getId()))
                .findFirst().orElseThrow(NoSuchElementException::new);
        userList.remove(findUser);
        add(user);
    }

    @Override
    public User remove(String id) {
        try {
            User user = userList.stream().filter(u -> u.getId().equals(id))
                    .findFirst().orElseThrow(NoSuchElementException::new);
            userList.remove(user);
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(Paths.get("users.json").toFile(), userList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser(String id) {
        User findUser = null;
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<ConcreteUser> readValues = mapper.readValue(Paths.get("users.json").toFile(), new TypeReference<>() {
            });

            findUser = readValues.stream().filter(o -> o.getId().equals(id))
                    .findFirst().orElseThrow(NoSuchElementException::new);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return findUser;
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<ConcreteUser> readValues = mapper.readValue(Paths.get("users.json").toFile(), new TypeReference<>() {
            });

            list.addAll(readValues);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return list;
        }
    }
}
