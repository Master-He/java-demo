package com.github.dao.impl;

import com.github.dao.BookDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author hewenji
 * @Date 2023/5/28 17:41
 */

@Repository("bookdao2")
public class BookDaoImpl2 implements BookDao {
    @Override
    public void get() {
        System.out.println("get");
    }

    @PostConstruct
    public void init() {
        System.out.println("init...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy...");
    }

    @Override
    public int getRandomNumber() {
        return 0;
    }

    @Override
    public int inc(int num) {
        return num+1;
    }
}
