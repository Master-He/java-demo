package com.github.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author hewenji
 * @Date 2023/5/28 18:12
 */

@Configuration
@ComponentScan("com.github")  // 单个路径
// @ComponentScan({"com.github.dao", "com.github.service"}) // 多个路径
@PropertySource({"classpath:bookdao.properties", "classpath:jdbc.properties"})
@Import({JDBCConfig.class, MybatisConfig.class}) // 导入配置类，配置第三方对象
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {
    // 有了SpringConfig， 就不用applicationContext.xml了
    // 将applicationContext.xml改名为applicationContext.xml.bak，使其失效

}
