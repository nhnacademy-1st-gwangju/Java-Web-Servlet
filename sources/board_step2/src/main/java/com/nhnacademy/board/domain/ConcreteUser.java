package com.nhnacademy.board.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public class ConcreteUser implements User, Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("password")
    private String password;
    @JsonProperty("name")
    private String name;
    @JsonProperty("profileFileName")
    private String profileFileName;

    @Override
    public String toString() {
        return "ConcreteUser{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", profileFileName='" + profileFileName + '\'' +
                '}';
    }
}
