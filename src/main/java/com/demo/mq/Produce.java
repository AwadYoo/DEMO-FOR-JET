package com.demo.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author 尤贺雨
 * @create 2019-02-25 16:12
 */
@Component
public class Produce {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    public void sendMsg(String destination, final String msg) {
        System.out.println("========发送queen消息" + msg);
        Destination des = new ActiveMQQueue(destination);
        jmsTemplate.convertAndSend(des, msg);
    }

}
