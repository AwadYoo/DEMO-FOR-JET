package com.deemo.service;


import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Task {

    @Autowired
    private HazelcastInstance hazelcastInstance;
    @Autowired
    private PublishEvent publishEvent;

//    @Scheduled(fixedRate = 500)
    public void testTask() {
        hazelcastInstance.getList("list").add(LocalDateTime.now());
        System.out.println("任务正在运行！");
        publishEvent.publish();
    }

}
