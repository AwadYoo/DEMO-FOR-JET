package com.demo.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.entity.User;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author awad_yoo
 * @create 2019-04-29 14:14
 */
@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public JSONArray list() {
        List<User> list = userService.list();
        JSONArray array = new JSONArray();
        array.addAll(list);
        return array;
    }

    @GetMapping("/add")
    public String add() {
        return userService.add(new User());
    }
}
