package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication  // 标注这个类是springboot应用
public class DemoApplication {

    public static void main(String[] args) {
        // run()将springboot应用启动
        // SpringApplication.run(DemoApplication.class, args);  // 默认的

        // 返回IOC容器
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        RedisTemplate redisTemplate = context.getBean("redisTemplate", RedisTemplate.class);


    }

}
