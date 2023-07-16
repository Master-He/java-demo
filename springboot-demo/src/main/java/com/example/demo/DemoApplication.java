package com.example.demo;

import com.example.demo.pojo.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * @ComponentScan 的默认扫描范围是： 当前引导类所在的包及其子包
 * 此时有几种解决方案
 * 1. 把要引入的第三方类的包路径作为参数传入 -> componentScan("com.other.component")
 * 2. 使用@Import注解，加载类， 这些类都会被Spring创建， 并放入IOC容器
 * 3. 可以对@Import注解进行封装，封装成@Enable*注解
 */


/**
 *     @Import的四个作用 https://zhuanlan.zhihu.com/p/344539305
 *     1. 导入配置类， 引入的配置类可以加@Configuration或者不加@Configuration
 *     2. 导入Bean， 直接创建类的Bean对象
 *     3. 导入实现ImportSelector接口的类(以及实现DefferredServiceImportSelector接口的类)，用于个性化加载，一般用于加载配置文件中的类
 *     4. 指定实现ImportBeanDefinitionRegistrar的类，用于个性化加载
 */

@SpringBootApplication  // 标注这个类是springboot应用
public class DemoApplication {

    public static void main(String[] args) {
        // run()将springboot应用启动
        // SpringApplication.run(DemoApplication.class, args);  // 默认的

        // 返回IOC容器
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        Map<String, Properties> beansOfType = context.getBeansOfType(Properties.class);
        for (String s : beansOfType.keySet()) {
            System.out.println(s);
        }

    }

}
