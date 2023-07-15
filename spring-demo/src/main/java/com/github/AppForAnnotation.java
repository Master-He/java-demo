package com.github;

import com.github.config.SpringConfig;
import com.github.dao.BookDao;
import com.github.service.BookServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author hewenji
 * @Date 2023/5/28 18:16
 */
public class AppForAnnotation {
    public static void main(String[] args) {
        // ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        // AnnotationConfigApplicationContext 才有close()方法
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        // BookDao bookDao = ctx.getBean(BookDao.class);
        BookDao bookDao = ctx.getBean("bookdao", BookDao.class);
        bookDao.get();
        int randomNumber = bookDao.getRandomNumber();
        System.out.println("random number：" + randomNumber);

        System.out.println("++++++++++++++++我是分割线+++++++++++++++++++++");
        BookServer bookServer = ctx.getBean(BookServer.class);
        bookServer.service();

        System.out.println("++++++++++++++++我是分割线+++++++++++++++++++++");
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource);

        // 关闭容器
        ctx.close();

    }
}
