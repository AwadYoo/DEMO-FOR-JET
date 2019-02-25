package com.demo.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author 尤贺雨
 * @create 2019-02-25 16:17
 */
@Service
public class Consumer {

    @JmsListener(destination = "test.queen")
    public void receiveMsg(String msg) {
        System.out.println("=====收到消息： " + msg);
    }
}
