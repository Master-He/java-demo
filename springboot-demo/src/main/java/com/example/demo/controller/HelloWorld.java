package com.example.demo.controller;

import com.example.demo.pojo.CityCodeConfig;
import com.example.demo.pojo.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hewenji
 * @Date 2023/5/30 9:27
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {

    private Properties properties;
    private CityCodeConfig cityCodeConfig;

    @Autowired
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Autowired
    public void setCityCodeConfig(CityCodeConfig cityCodeConfig) {
        this.cityCodeConfig = cityCodeConfig;
    }

    @RequestMapping("/world")
    public String helloWorld() {

        /**
         * 属性赋值3种方法
         *  1. @Value
         *  2. Environment加@Autowired   此方法是获取所有对象
         *  3. 类上加@ConfigurationProperties
         */


        // 1. @Value
        System.out.println(properties.getAuthorName());
        System.out.println(properties.getAuthorAge());
        System.out.println(properties.getAddressList());

        // 2. Environment加@Autowired   此方法是获取所有对象
        Environment environment = properties.getEnvironment();
        String other = environment.getProperty("author.other", String.class);
        System.out.println(other);

        // 3. 类上加@ConfigurationProperties
        System.out.println(cityCodeConfig.getList());
        System.out.println(cityCodeConfig.getMap());

        return "hello world.";
    }

    public int add(int a, int b) {
        return a+b;
    }
}
