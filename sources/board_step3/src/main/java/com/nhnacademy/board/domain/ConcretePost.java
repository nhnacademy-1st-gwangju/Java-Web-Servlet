package com.nhnacademy.board.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class ConcretePost implements Post, Serializable {
    @JsonProperty("id")
    private long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private String content;
    @JsonProperty("writerUserId")
    private String writerUserId;
    @JsonProperty("writeTime")
    private LocalDateTime writeTime = LocalDateTime.now();
    @JsonProperty("viewCount")
    private int viewCount;

    @Override
    public void increaseViewCount() {
        ++this.viewCount;
    }

    @Override
    public String toString() {
        return "ConcretePost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writerUserId='" + writerUserId + '\'' +
                ", writeTime=" + writeTime +
                ", viewCount=" + viewCount +
                '}';
    }
}
