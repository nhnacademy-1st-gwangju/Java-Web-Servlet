package com.nhnacademy.board.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JsonUserRepositoryTest {

    private JsonUserRepository repository;
    private ConcreteUser user;

    @BeforeEach
    void init() {
        repository = new JsonUserRepository();
        user = new ConcreteUser();
        user.setId("songs4805");
        user.setName("Ramos");
    }

    @Test
    @DisplayName("User 등록 시 JSON File에 정상적으로 저장된다.")
    void add() {
        //given
        ConcreteUser user2 = new ConcreteUser();
        user2.setId("test");
        user2.setName("test");

        //when
        repository.add(user);
        repository.add(user2);

        //then
        assertThat(repository.getUsers()).hasSize(2);
        assertThat(repository.getUsers().get(0).getId()).isEqualTo(user.getId());
        assertThat(repository.getUsers().get(1).getId()).isEqualTo(user2.getId());

    }

    @Test
    @DisplayName("User 수정 시 JSON File에 정상적으로 반영된다.")
    void modify() {
        //given
        repository.add(user);

        String password = "12345";
        user.setPassword(password);

        //when
        repository.modify(user);

        //then
        assertThat(repository.getUsers().get(0).getPassword()).isEqualTo(password);

    }

    @Test
    @DisplayName("User 삭제 시 JSON File에 정상적으로 반영된다.")
    void remove() {
        //given
        repository.add(user);

        //when
        repository.remove(user.getId());

        //then
        assertThat(repository.getUsers()).isEmpty();
    }

    @Test
    @DisplayName("User Id로 해당하는 사용자를 JSON 파일에서 찾아온다.")
    void getUser() {
        //given
        repository.add(user);

        //when
        User findUser = repository.getUser(this.user.getId());

        //then
        assertThat(findUser.getId()).isEqualTo(user.getId());
        assertThat(findUser.getPassword()).isEqualTo(user.getPassword());
        assertThat(findUser.getName()).isEqualTo(user.getName());
        assertThat(findUser.getProfileFileName()).isEqualTo(user.getProfileFileName());
    }

    @Test
    @DisplayName("등록된 사용자 전체를 JSON 파일에서 읽어온다.")
    void getUsers() {
        //given
        ConcreteUser user2 = new ConcreteUser();
        user2.setId("test");
        user2.setName("test");
        repository.add(user);
        repository.add(user2);

        //when
        List<User> users = repository.getUsers();

        //then
        assertThat(users).hasSize(2);
    }
}