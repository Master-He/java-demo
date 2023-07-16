package com.example.demo.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author hewenji
 * @Date 2023/7/16 10:37
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(ConditionClass2.class)
public @interface ConditionOnClass {
    String[] value();
}
