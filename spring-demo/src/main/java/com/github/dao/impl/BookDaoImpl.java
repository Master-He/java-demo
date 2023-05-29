package com.github.dao.impl;

import com.github.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

/**
 * @author hewenji
 * @Date 2023/5/28 17:41
 */
// @Component
// @Controller
// @Service
@Repository("bookdao")
// @Scope("singleton")  // 默认单例
// @Scope("prototype")
public class BookDaoImpl implements BookDao {

    // @Value("bookDaoImpl")
    @Value("${name}")
    private String name;

    @Override
    public void get() {
        System.out.println("get: " + this.name);
    }

    @Override
    public int getRandomNumber() {
        System.out.println("generate random number");
        return new Random().nextInt(10);
    }

    @Override
    public int inc(int num) {
        return num+1;
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
    public String toString() {
        return "BookDaoImpl{" +
            "name='" + name + '\'' +
            '}';
    }
}
