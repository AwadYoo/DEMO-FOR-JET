package com.deemo.controller;

import com.deemo.repo.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private BuildingRepo repo;

    @GetMapping("/test")
    public Object test() {
        return repo.findAll();
    }

}
