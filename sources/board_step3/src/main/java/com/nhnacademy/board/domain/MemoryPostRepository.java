package com.nhnacademy.board.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class MemoryPostRepository implements PostRepository {

    private Map<Long, Post> postMap;
    private Long postId;

    @Autowired
    public MemoryPostRepository() {
        this.postMap = new ConcurrentHashMap<>();
        this.postId = 1L;
    }

    @Override
    public long register(Post post) {
        post.setId(this.postId);
        postMap.put(this.postId, post);
        ++this.postId;
        return post.getId();
    }

    @Override
    public void modify(Post post) {
        if (postMap.containsKey(post.getId())) {
            post.setWriteTime(LocalDateTime.now());
            postMap.replace(post.getId(), post);
        }
    }

    @Override
    public Post remove(long id) {
        return postMap.remove(id);
    }

    @Override
    public Post getPost(long id) {
        return postMap.getOrDefault(id, null);
    }

    @Override
    public List<Post> getPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public int getTotalCount() {
        return postMap.values().size();
    }

    @Override
    public Page<Post> getPagedPosts(int page, int size) {
        List<Post> posts = getPosts();

        int resultPerPage = 10;

        int skipCount = (page - 1) * resultPerPage;
        List<Post> list = posts.stream().skip(skipCount)
                .limit(resultPerPage)
                .collect(Collectors.toList());

        return new PageImpl<>(page, getTotalCount(), list);
    }
}
