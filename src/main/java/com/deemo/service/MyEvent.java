package com.deemo.service;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Builder(toBuilder = true)
public class MyEvent {


    public void printMsg() {
//        System.out.println("监听到List的大小为：" + hazelcastInstance.getList("list").size());
        System.out.println("监听到");
    }
}
