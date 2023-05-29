package com.github;

import com.github.config.SpringConfig;
import com.github.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hewenji
 * @Date 2023/5/29 14:52
 */
public class AppForMybatis {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = ctx.getBean(UserService.class);

        // User user = new User();
        // user.setBirthday(new Date(System.currentTimeMillis()));
        // user.setEmail("user@.qq.com");
        // user.setMoney(122);
        // user.setName("user");
        // user.setPassword("123");
        // userService.create(user); // 调试执行，然后看数据库结果

        // User user2 = new User();
        // user2.setName("user2");
        // user2.setId(14);
        // userService.update(user2);  // 调试执行，然后看数据库结果

        System.out.println(userService.selectById(1));  // 调试执行，然后看数据库结果

        // userService.delete(11); // 调试执行，然后看数据库结果


    }
}
