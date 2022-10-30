package com.nhnacademy.board.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JsonPostRepositoryTest {

    private JsonPostRepository repository;
    private ConcretePost post;

    @BeforeEach
    void init() {
        repository = new JsonPostRepository();
        post = new ConcretePost();
        post.setTitle("title test");
        post.setContent("content test");
        post.setWriterUserId("Ramos");
    }

    @Test
    @DisplayName("Post 등록 시 JSON File에 정상적으로 저장되고, id 값이 올바르게 반환된다.")
    void register() {
        //given
        ConcretePost post2 = new ConcretePost();
        post2.setContent("test2");

        //when
        long resultId = repository.register(post);
        long result2 = repository.register(post2);

        //then
        assertThat(resultId).isEqualTo(1);
        assertThat(result2).isEqualTo(2);
    }

    @Test
    @DisplayName("Post 수정 시 작성 시간도 변경되며, JSON File에 정상적으로 반영된다.")
    void modify() {
        //given
        repository.register(post);
        Post before = repository.getPost(1L);
        this.post.setTitle("title change");
        this.post.setContent("content change");

        //when
        repository.modify(this.post);

        //then
        Post after = repository.getPosts().get(0);
        assertThat(after.getTitle()).isEqualTo(this.post.getTitle());
        assertThat(after.getContent()).isEqualTo(this.post.getContent());
        assertThat(after.getWriteTime()).isNotEqualTo(before.getWriteTime());
    }

    @Test
    @DisplayName("Post 삭제 시 JSON File에 정상적으로 반영된다.")
    void remove() {
        //given
        repository.register(post);

        //when
        repository.remove(1L);

        //then
        assertThat(repository.getPosts()).isEmpty();
    }

    @Test
    @DisplayName("해당하는 게시글을 JSON 파일에서 찾아온다.")
    void getPost() {
        //given
        repository.register(post);

        //when
        Post findPost = repository.getPost(1L);

        //then
        assertThat(findPost.getId()).isEqualTo(1L);
        assertThat(findPost.getTitle()).isEqualTo(post.getTitle());
        assertThat(findPost.getContent()).isEqualTo(post.getContent());
        assertThat(findPost.getWriteTime()).isNotNull();
    }

    @Test
    @DisplayName("등록된 게시글 전체를 JSON 파일에서 읽어온다.")
    void getPosts() {
        //given
        ConcretePost post2 = new ConcretePost();
        post2.setTitle("title2");
        post2.setContent("content2");
        post2.setWriterUserId("Ramos");

        repository.register(post);
        repository.register(post2);


        //when
        List<Post> findPosts = repository.getPosts();

        //then
        assertThat(findPosts).hasSize(2);
    }

    @Test
    @DisplayName("JSON 파일에 등록된 게시글 총 개수를 반환한다.")
    void getTotalCount() {
        //given
        repository.register(post);

        //when
        int totalCount = repository.getTotalCount();

        //then
        assertThat(totalCount).isEqualTo(1);
    }

    @Test
    @DisplayName("페이지 번호에 따라 해당하는 구간의 데이터와 페이지 번호, 총 페이지 수를 반환한다.")
    void getPagedPosts() {
        //given
        int totalNum = 42;
        int givenPage = 2;
        int givenSize = 10;

        for (int i = 1; i <= totalNum; i++) {
            post = new ConcretePost();
            post.setTitle("testTitle" + i);
            post.setContent("testContent" + i);
            post.setWriterUserId("testWriter" + i);
            repository.register(post);
        }

        //when
        Page<Post> pagedPosts = repository.getPagedPosts(givenPage, givenSize);

        //then
        assertThat(pagedPosts.getPageNumber()).isEqualTo(givenPage);
        assertThat(pagedPosts.getPageSize()).isEqualTo(givenSize);
        assertThat(pagedPosts.getTotalPageCount()).isEqualTo(5);
        assertThat(pagedPosts.getTotalCount()).isEqualTo(totalNum);

        List<Post> list = pagedPosts.getList();
        assertThat(list.get(0).getId()).isEqualTo(11);
        assertThat(list.get(9).getId()).isEqualTo(20);

    }
}