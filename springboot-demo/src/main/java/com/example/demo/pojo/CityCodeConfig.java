package com.example.demo.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author hewenji
 * @Date 2023/7/15 17:51
 */
@Data
@Component
@ConfigurationProperties(prefix = "citycode")
public class CityCodeConfig {
    private List<String> list;
    private Map<String, String> map;
}
