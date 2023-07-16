package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hewenji
 * @Date 2023/7/15 19:36
 */
@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testGetUserDao() {
        System.out.println(userDao.selectById(1));
    }

    @Test
    void testFindAll() {
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void createUser() {
        // User hhhh = new User(
        //     "111",
        //     "hhhh",
        //     "hhhh@qq.com",
        //     new Date(System.currentTimeMillis()),
        //     123
        // );
        // userDao.create(hhhh);
    }
}