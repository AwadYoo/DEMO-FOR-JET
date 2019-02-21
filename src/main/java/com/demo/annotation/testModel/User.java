package com.demo.annotation.testModel;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {

    @NotNull(message = "名称不能为空")
    private String name;



    public static void main(String[] args) {

        System.out.println(new User());
//        System.out.println(UserFactory.create());
    }
}
