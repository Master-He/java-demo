package com.github.service.impl;

import com.github.dao.BookDao;
import com.github.service.BookServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author hewenji
 * @Date 2023/5/28 17:46
 */
// @Component
@Service
public class BookServerImpl implements BookServer {

    @Autowired  //自动帮你注入依赖(Autowired是按类型装配的)
    @Qualifier("bookdao")  // 多个实现类的时候才需要用Qualifier
    private BookDao bookDao;

    // @Autowired  // 也可以加在这里， // setBookDao()甚至可以去掉，因为底层是使用反射来初始化成员变量的
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @Override
    public void service() {
        System.out.println("service");
        bookDao.get();
    }
}
