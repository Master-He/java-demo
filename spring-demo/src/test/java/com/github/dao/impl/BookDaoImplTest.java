package com.github.dao.impl;

import com.github.config.SpringConfig;
import com.github.dao.BookDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hewenji
 * @Date 2023/5/29 17:30
 */
// 配置spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookDaoImplTest {

    @Autowired
    @Qualifier("bookdao")
    private BookDao bookDao;

    @Test
    public void get() {
        bookDao.get();
        System.out.println(bookDao);
        System.out.println(bookDao.getClass()); // 发现是代理类 ， 比如：class com.sun.proxy.$Proxy36
    }

    @Test
    public void getNumber() {
        System.out.println(bookDao.getRandomNumber());
    }

    @Test
    public void inc() {
        System.out.println(bookDao.inc(1));
    }
}