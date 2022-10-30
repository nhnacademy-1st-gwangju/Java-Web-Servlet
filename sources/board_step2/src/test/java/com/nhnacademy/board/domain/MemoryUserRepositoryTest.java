package com.nhnacademy.board.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryUserRepositoryTest {

    private MemoryUserRepository repository;
    private ConcreteUser user;

    @BeforeEach
    void init() {
        repository = new MemoryUserRepository();
        user = new ConcreteUser();
        user.setId("songs4805");
        user.setName("Ramos");
    }

    @Test
    @DisplayName("사용자 등록 시 정상적으로 등록된다.")
    void add() {
        //given
        String userId = user.getId();

        //when
        repository.add(user);

        //then
        assertThat(user.getId()).isEqualTo(repository.getUser(userId).getId());
    }

    @Test
    @DisplayName("등록된 사용자의 정보 변경 시 정상적으로 변경된다.")
    void modify() {
        //given
        String userId = user.getId();
        repository.add(user);
        user.setName("Sergio");

        //when
        repository.modify(user);

        //then
        assertThat(user.getName()).isEqualTo(repository.getUser(userId).getName());
    }

    @Test
    @DisplayName("등록된 사용자는 정상적으로 삭제된다.")
    void remove() {
        //given
        String userId = user.getId();
        repository.add(user);

        //when
        repository.remove(userId);

        //then
        assertThat(repository.getUser(userId)).isNull();
    }

    @Test
    @DisplayName("등록된 사용자는 정상적으로 조회된다.")
    void getUser() {
        //given
        repository.add(user);
        String userId = user.getId();

        //when
        User find = repository.getUser(userId);

        //then
        assertThat(user).isEqualTo(find);
        assertThat(userId).isEqualTo(find.getId());
    }

    @Test
    @DisplayName("등록된 사용자들의 목록이 정상적으로 조회된다.")
    void getUsers() {
        //given
        repository.add(user);

        //when
        List<User> users = repository.getUsers();

        //then
        assertThat(users).hasSize(1);
    }
}