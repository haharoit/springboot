package com.haharoit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description: User Entity
 * @author haharoit
 * @version 1.0.0
 * @createtime 2018-05-30 am
 * @updatetime 2018-06-01 am
 */
@Data//A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!
@Entity
@AllArgsConstructor
public class User {

    public User() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;



    //lombok在编译时自动生成getter，setter
}
