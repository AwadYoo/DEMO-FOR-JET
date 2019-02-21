package com.demo.service;

import lombok.Builder;

@Builder(toBuilder = true)
public class MyEvent {


    public void printMsg() {
//        System.out.println("监听到List的大小为：" + hazelcastInstance.getList("list").size());
        System.out.println("监听到");
    }
}
