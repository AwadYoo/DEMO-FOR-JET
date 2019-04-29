package com.demo.service;

import com.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> list();

    String add(User user);
}
