package com.example.demo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author hewenji
 * @Date 2023/7/16 9:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PojoForTest {
    // @Value("pojo for test")
    private String name;
}
