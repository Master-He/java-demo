package com.example.demo.enable.config;

import com.example.demo.enable.pojo.Person;
import com.example.demo.enable.pojo.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hewenji
 * @Date 2023/7/16 17:26
 */
@Configuration
public class ForTestConfig {

    @Bean
    public Person person() {
        return new Person("hwj");
    }

    @Bean
    public Role role() {
        return new Role("hbh");
    }
}
