package com.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author awad_yoo
 * @create 2019-04-18 16:47
 */
@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/{str}")
    public String testSet(@PathVariable String str) {
        redisTemplate.opsForValue().set("study", "java");
        return redisTemplate.opsForValue().get(str);
    }

}
