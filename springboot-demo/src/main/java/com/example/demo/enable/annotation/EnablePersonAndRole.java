package com.example.demo.enable.annotation;

import com.example.demo.enable.pojo.Person;
import com.example.demo.enable.pojo.Role;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author hewenji
 * @Date 2023/7/16 18:01
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({Person.class, Role.class})
public @interface EnablePersonAndRole {
}
