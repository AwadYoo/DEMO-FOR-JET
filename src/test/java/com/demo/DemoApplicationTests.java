//package com.demo;
//
//import com.demo.mq.Produce;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DemoApplicationTests {
//
//    @Resource
//    private Produce produce;
//
//    @Test
//    public void contextLoads() {
//
//        for (int i = 0; i < 10; i++) {
//            produce.sendMsg("test.queen", "queen Msg " + i);
//
//        }
//    }
//}
//
