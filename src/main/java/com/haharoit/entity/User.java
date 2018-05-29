package com.haharoit.entity;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private Integer age;

    //省略getter，setter
}
