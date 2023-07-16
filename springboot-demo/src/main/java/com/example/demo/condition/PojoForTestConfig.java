package com.example.demo.condition;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

import java.lang.reflect.Field;

/**
 * @author hewenji
 * @Date 2023/7/16 9:57
 */
@Configuration
// @ComponentScan
public class PojoForTestConfig {

    @Bean
    // @Primary
    // @Conditional(ConditionClass.class)
    // @ConditionOnClass({"org.apache.commons.lang3.StringUtils"}) // 可以更灵活
    @ConditionOnClass({"org.apache.commons.lang3.StringUtils","com.mysql.cj.jdbc.Driver"})
    public PojoForTest pojoForTest() throws ReflectiveOperationException {
        // 反射获取值并赋值
        PojoForTest pojoForTest = PojoForTest.class.newInstance();
        for (Field field : PojoForTest.class.getDeclaredFields()) {
            field.setAccessible(true);
            Value annotation = field.getAnnotation(Value.class);
            if (annotation == null) {
                field.set(pojoForTest, "default");
            } else {
                String value = annotation.value();
                field.set(pojoForTest, value);
            }

        }
        return pojoForTest;

    }


    @Bean
    @Qualifier("pojoForTest2")
    @ConditionalOnProperty(name = "author.name", havingValue = "hwj")
    // @ConditionalOnProperty(name = "author.name", havingValue = "hwj2") // 这个时候就不会注入pojoForTest2对象
    public PojoForTest pojoForTest2() {
        return new PojoForTest("hwj");
    }


}
