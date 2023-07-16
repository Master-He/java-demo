package com.example.demo.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author hewenji
 * @Date 2023/7/16 9:32
 */
public class ConditionClass implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        boolean flag = true;

        try {
            // 这里写死了 判断  org.apache.commons.lang3.StringUtils  是否存在
            Class.forName("org.apache.commons.lang3.StringUtils");
        } catch (ClassNotFoundException e) {
            flag = false;
        }

        return flag;
    }
}
