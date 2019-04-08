package com.demo.service.schedule;

import com.demo.mq.Produce;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时MQ消息发送测试
 *
 * @author 尤贺雨
 * @create 2019-02-25 16:49
 */
@Component
@Log4j2
public class MqSchedule {


    String msg = "{ \"specclass\": \"HVAC\", \"assetnum\": \"P010910_0027\", \"assetdescription\": \"X401YL新风机组\", \"assetattrid\": \"status_damper_oa\", \"assetattrdescription\": \"新风阀反馈\", \"measureunitid\": \"—\", \"measurevalue\": \"0\", \"measurevaluedescription\": \"关闭\" }";

    @Autowired
    private Produce produce;

    //@Scheduled(fixedRate = 1000)
    //public void MqSendMsg() {
    //    produce.sendMsg("test.queen", "这是一个 每一秒 定时发送的消息测试：" + Math.random());
    //    log.info("定时一秒的消息正在发送。。。");
    //}

    @Scheduled(cron = "0/5 * * * * ?")
    public void MqSendMsg2() {
        produce.sendMsg("test.queen", msg);
    }
}

