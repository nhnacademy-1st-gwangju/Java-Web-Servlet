package com.nhnacademy.board.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryPostRepository implements PostRepository {

    private Map<Long, Post> postMap = new ConcurrentHashMap<>();
    private Long postId = 1L;

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
}
