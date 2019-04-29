package com.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author awad_yoo
 * @create 2019-04-18 16:19
 */
public class TestRedis {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void testSet() {
        this.redisTemplate.opsForValue().set("study", "java");
        System.out.println(this.redisTemplate.opsForValue().get("study"));
    }

}
