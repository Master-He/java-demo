package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hewenji
 * @Date 2023/7/15 18:32
 */
@SpringBootTest
public class HelloRedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testSet() {
        // redisTemplate.boundValueOps("name").set("zhangsan");
    }

    @Test
    public void name() {
        // String name = redisTemplate.boundValueOps("name").get();
        // assertEquals("zhangsan", name);
    }
}
