package com.nhnacademy.board.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
@Primary
public class JsonPostRepository implements PostRepository {

    private List<Post> postList;
    private Long postId;

    @Autowired
    public JsonPostRepository() {
        this.postList = Collections.synchronizedList(new ArrayList<>());
        this.postId = 1L;
    }

    @Override
    public long register(Post post) {
        try {
            if (postList.contains(post)) {
                throw new IllegalArgumentException("중복");
            } else {
                post.setId(this.postId);
                postList.add(post);
                ++this.postId;
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                mapper.writeValue(Paths.get("posts.json").toFile(), postList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return post.getId();
    }

    @Override
    public void modify(Post post) {
        try {
            Post findPost = postList.stream().filter(p -> p.getId() == post.getId())
                    .findFirst().orElseThrow(NoSuchElementException::new);

            post.setWriteTime(LocalDateTime.now());
            long id = findPost.getId();
            postList.set(Long.valueOf(id).intValue()-1, post);

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(Paths.get("posts.json").toFile(), postList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Post remove(long id) {
        try {
            Post post = postList.stream().filter(u -> u.getId() == id)
                    .findFirst().orElseThrow(NoSuchElementException::new);
            postList.remove(post);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(Paths.get("posts.json").toFile(), postList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Post getPost(long id) {
        Post findPost = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<ConcretePost> readValues = mapper.readValue(Paths.get("posts.json").toFile(), new TypeReference<>() {
            });

            findPost = readValues.stream().filter(o -> o.getId() == id)
                    .findFirst().orElseThrow(NoSuchElementException::new);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return findPost;
        }
    }

    @Override
    public List<Post> getPosts() {
        List<Post> list = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<ConcretePost> readValues = mapper.readValue(Paths.get("posts.json").toFile(), new TypeReference<>() {
            });

            list.addAll(readValues);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return list;
        }
    }

    @Override
    public int getTotalCount() {
        return getPosts().size();
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
