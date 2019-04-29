package com.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.repo.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {

//    @Autowired
//    private BuildingRepo repo;
//
//    @GetMapping("/test")
//    public Object test() {
//        return repo.findAll();
//    }
////    http://host:port
//
//    @GetMapping("/portal/asset/specs.json")
//    public JSONArray getTest(@RequestParam String assetnum, @RequestParam String action) {
//
//        String str = "[ { \"assetspecid\": 28398, \"alnvalue\": \"BA_CP_DSY_5F_8E_OAD1_CFB\", \"assetattrid\": \"status_damper_oa\", \"assetnum\": \"P01030901_0013\", \"classstructureid\": \"P01030901\", \"displaysequence\": 0, \"measureunitid\": \"—\", \"numvalue\": 8449, \"tablevalue\": \"新风阀关反馈\", \"description\": \"新风阀反馈\", \"initvalue\": null, \"measurevalue\": 8449, \"sysdomain\": { \"sysdomainid\": 17, \"domainid\": \"VALVE\", \"description\": \"阀门状态\", \"domaintype\": \"NUMERIC\", \"datatype\": \"SMALLINT\", \"length\": 4, \"scale\": 0, \"internal\": 1, \"datatypes\": [], \"numericDomains\": [ { \"numericdomainid\": 40, \"domainid\": \"VALVE\", \"value\": 0, \"description\": \"关闭\", \"valueid\": \"VALVE|0\", \"color\": null, \"icon\": null, \"orgid\": null, \"siteid\": null, \"displaysequence\": 0 }, { \"numericdomainid\": 56, \"domainid\": \"VALVE\", \"value\": 2, \"description\": \"打开\", \"valueid\": \"VALVE|2\", \"color\": null, \"icon\": null, \"orgid\": null, \"siteid\": null, \"displaysequence\": 0 } ], \"alnDomains\": [], \"synonymDomains\": [], \"numRangeDomains\": [] } } ]";
//        JSONArray array = JSONArray.parseArray(str);
//        return array;
//    }
//
//    @Autowired
//    private Produce produce;
//
//    @GetMapping("/msg/{msg}")
//    public String sendMsgMq(@PathVariable String msg) {
//        produce.sendMsg("test.queen", msg);
//        return msg;
//    }

//
//    @GetMapping("/")
//    public ModelAndView test1() {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("hello");
//        return mv;
//    }

//    @GetMapping("/")
//    public JSONObject test2() {
//        JSONObject object = new JSONObject();
//        object.put("name", "尤贺雨");
//        object.put("password", 123456);
//        return object;
//    }
}
