package com.github.service.impl;

import com.github.config.SpringConfig;
import com.github.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hewenji
 * @Date 2023/5/29 17:03
 */

// 配置spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void create() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void selectById() {
        System.out.println(userService.selectById(1));
    }

}