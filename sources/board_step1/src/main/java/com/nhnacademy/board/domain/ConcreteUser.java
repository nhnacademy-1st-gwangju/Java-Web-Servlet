package com.nhnacademy.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public class ConcreteUser implements User, Serializable {
    private String id;
    private String password;
    private String name;
    private String profileFileName;
}
