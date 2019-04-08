//package com.demo.mq;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.demo.entity.GatheringData;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
///**
// * @author 尤贺雨
// * @create 2019-02-25 16:17
// */
//@Service
//@Log4j2
//public class Consumer {
//
//    @JmsListener(destination = "test.queen")
//    public void receiveMsg(String msg) {
//        log.info("收到消息： " + msg);
//
//        GatheringData data = JSON.parseObject(msg, GatheringData.class);
//        log.info(data);
//
//    }
//}
