package com.demo.service.impl;

import com.demo.entity.User;
import com.demo.repo.UserRepo;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author awad_yoo
 * @create 2019-04-29 14:09
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> list() {
        return userRepo.findAll();
    }

    @Override
    public String add(User user) {
        try {
            for (long i = 0; i < 500; i++) {
                userRepo.save(new User(i, "尤贺雨", 20));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

}
