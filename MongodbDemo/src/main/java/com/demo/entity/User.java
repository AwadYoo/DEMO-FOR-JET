package com.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author awad_yoo
 * @create 2019-04-29 14:03
 */
@Data
public class User implements Serializable {

    @Id
    private Long id;

    private String name;

    private Integer age;

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}
