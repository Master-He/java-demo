package com.example.demo.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author hewenji
 * @Date 2023/7/15 17:09
 */

@Data
@Slf4j
@Component
public class Properties {

    /**
     * 属性赋值3种方法
     *  1. @Value
     *  2. Environment加@Autowired   此方法是获取所有对象
     *  3. 类上加@ConfigurationProperties
     */
    @Value("${author.name}")
    private String authorName;
    @Value("${author.age}")
    private String authorAge;
    @Value("#{'${author.info.address}'.split(',')}")
    private List<String> addressList;

    @Autowired
    private Environment environment;
}
