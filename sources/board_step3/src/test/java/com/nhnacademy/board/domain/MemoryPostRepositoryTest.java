package com.nhnacademy.board.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryPostRepositoryTest {

    private MemoryPostRepository repository;
    private ConcretePost post;

    @BeforeEach
    void init() {
        repository = new MemoryPostRepository();
        post = new ConcretePost();
        post.setTitle("testTitle");
        post.setContent("testContent");
        post.setWriterUserId("testWriter");
    }

    @Test
    @DisplayName("게시글 등록 시 id값을 반환한다.")
    void register() {
        //given
        long before = 0;

        //when
        long postId = repository.register(post);
        post.setId(postId);

        //then
        assertThat(postId).isEqualTo(before+1);
    }

    @Test
    @DisplayName("게시글 수정 시 작성 시간이 변경된다.")
    void modify() {
        //given
        long postId = repository.register(post);
        post.setId(postId);
        LocalDateTime firstTime = post.getWriteTime();

        //when
        repository.modify(post);

        //then
        assertThat(post.getWriteTime()).isNotEqualTo(firstTime);
    }

    @Test
    @DisplayName("등록된 게시글을 id값을 기준으로 삭제 시 정상적으로 삭제된다.")
    void remove() {
        //given
        long postId = repository.register(post);

        //when
        repository.remove(postId);

        //then
        assertThat(repository.getPost(postId)).isNull();
    }

    @Test
    @DisplayName("게시글이 있는 경우 정상적으로 조회된다.")
    void getPost() {
        //given
        long postId = repository.register(post);

        //when
        Post post = repository.getPost(postId);

        //then
        assertThat(post).isNotNull();
    }

    @Test
    @DisplayName("게시글이 없는 경우 Null이 반환된다.")
    void getPostFail() {
        //given
        long postId = 3L;

        //when
        Post post = repository.getPost(postId);

        //then
        assertThat(post).isNull();
    }

    @Test
    @DisplayName("게시글 리스트를 반환한다.")
    void getPosts() {
        //given
        repository.register(post);
        repository.register(post);
        repository.register(post);

        //when
        List<Post> posts = repository.getPosts();

        //then
        assertThat(posts.size()).isEqualTo(3);
    }
    
    @Test
    @DisplayName("데이터의 총 개수를 반환한다.")
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