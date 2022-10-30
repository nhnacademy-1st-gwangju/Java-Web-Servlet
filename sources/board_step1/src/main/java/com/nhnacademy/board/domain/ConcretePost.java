package com.nhnacademy.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class ConcretePost implements Post, Serializable {
    private long id;
    private String title;
    private String content;
    private String writerUserId;
    private LocalDateTime writeTime = LocalDateTime.now();
    private int viewCount;

    @Override
    public void increaseViewCount() {
        ++this.viewCount;
    }
}
