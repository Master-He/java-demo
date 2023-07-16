package com.example.demo.condition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * @author hewenji
 * @Date 2023/7/16 9:35
 */
@SpringBootApplication
public class ForTestConditionApplication {
    public static void main(String[] args) {

        /*
         *  笔记：自动配置
         *  Condition注解，导入了类对应的组件的GAV后，就会加载改类。 否则不加载
         *   0.Condition
         *   1.ConditionalOnClass
         *   2.ConditionalOnSingleCandidate
         *   3.ConditionalOnMissingBean
         *
         * */

        /*
            @Import的四个作用  https://zhuanlan.zhihu.com/p/344539305
            1. 引入其他的@Configuration
            2. 直接初始化其他类的Bean
            3. 指定实现ImportSelector(以及DefferredServiceImportSelector)的类，用于个性化加载
            4. 指定实现ImportBeanDefinitionRegistrar的类，用于个性化加载
        * */

        ConfigurableApplicationContext context = SpringApplication.run(ForTestConditionApplication.class);

        // 自己实现Condition注解： 根据是否引入common.lang3.依赖，来判断是否注入pojoForTest对象
        // 1. 先写硬代码，手动控制让这个类加载和不加载。
        // 2. 根据是否引入common.lang3依赖，来判断是否注入pojoForTest对象
        // 3. 更加灵活，根据是否引入xxx依赖， 来判断是否注入pojoForTest对象， 自己创建ConditionOnClass类， 模仿ConditionalOnClass
        PojoForTest pojoForTest = context.getBean("pojoForTest", PojoForTest.class);
        System.out.println(pojoForTest.getName());

        PojoForTest pojoForTest2 = context.getBean("pojoForTest2", PojoForTest.class);
        System.out.println(pojoForTest2.getName());

        System.out.println(pojoForTest.hashCode() == pojoForTest2.hashCode());

    }
}
