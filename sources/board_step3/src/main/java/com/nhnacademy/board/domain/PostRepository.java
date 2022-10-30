package com.nhnacademy.board.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostRepository {
    long register(Post post);
    void modify(Post post);
    Post remove(long id);
    Post getPost(long id);
    List<Post> getPosts();
    int getTotalCount();
    Page<Post> getPagedPosts(int page, int size);
}
