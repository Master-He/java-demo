package com.example.demo.enable;

import com.example.demo.enable.annotation.EnablePersonAndRole;
import com.example.demo.enable.pojo.Person;
import com.example.demo.enable.pojo.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;


/**
 *     @Import的四个作用 https://zhuanlan.zhihu.com/p/344539305
 *     1. 导入配置类， 引入的配置类可以加@Configuration或者不加@Configuration
 *     2. 导入Bean， 直接创建类的Bean对象
 *     3. 导入实现ImportSelector接口的类(以及实现DefferredServiceImportSelector接口的类)，用于个性化加载，一般用于加载配置文件中的类
 *     4. 指定实现ImportBeanDefinitionRegistrar的类，用于个性化加载
 */


/**
 * @author hewenji
 * @Date 2023/7/16 17:21
 */
// @Import({Person.class, Role.class})
// @Import(ForTestConfig.class)
// @Import(MyImportSelector.class)
// @Import(MyImportBeanDefinitionRegistrar.class)
@EnablePersonAndRole()
@SpringBootApplication
public class ForTestEnableImportApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext text = SpringApplication.run(ForTestEnableImportApplication.class);

        Map<String, Person> personBeansOfType = text.getBeansOfType(Person.class);
        for (String key : personBeansOfType.keySet()) {
            System.out.printf("key: %s, bean: %s\n", key, personBeansOfType.get(key));
        }

        Map<String, Role> roleBeansOfType = text.getBeansOfType(Role.class);
        for (String key : roleBeansOfType.keySet()) {
            System.out.printf("key: %s, bean: %s\n", key, roleBeansOfType.get(key));
        }

    }
}
