package com.github.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author hewenji
 * @Date 2023/5/28 18:12
 */

/*
@Import的四个作用  https://zhuanlan.zhihu.com/p/344539305
1. 引入其他的@Configuration
2. 直接初始化其他类的Bean
3. 指定实现ImportSelector(以及DefferredServiceImportSelector)的类，用于个性化加载
4. 指定实现ImportBeanDefinitionRegistrar的类，用于个性化加载
* */


@Configuration
@ComponentScan("com.github")  // 单个路径
// @ComponentScan({"com.github.dao", "com.github.service"}) // 多个路径
@PropertySource({"classpath:bookdao.properties", "classpath:jdbc.properties"})
@Import({JDBCConfig.class, MybatisConfig.class}) // 导入配置类，配置第三方对象 //
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {
    // 有了SpringConfig， 就不用applicationContext.xml了
    // 将applicationContext.xml改名为applicationContext.xml.bak，使其失效

}
