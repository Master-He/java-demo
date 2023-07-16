package com.example.demo.controller;

import com.example.demo.DemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hewenji
 * @Date 2023/7/15 17:59
 */

// @SpringBootTest(classes = DemoApplication.class)
@SpringBootTest // 如果DemoApplication类和HelloWorld类是同一个包下，则可以胜率classes属性
class HelloWorldTest {

    @Autowired
    private HelloWorld helloWorld;

    @Test
    public void testAdd() {
        assertEquals(2, helloWorld.add(1,1));
    }
}