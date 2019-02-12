package com.deemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class PublishEvent {

    @Autowired
    private ApplicationContext context;

    public void publish() {
        context.publishEvent(new MyEvent());
    }

}
