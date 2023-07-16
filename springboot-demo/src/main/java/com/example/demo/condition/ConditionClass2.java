package com.example.demo.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author hewenji
 * @Date 2023/7/16 9:32
 */
public class ConditionClass2 implements Condition {

    /**
     *
     * @param context 上下文对象，可以获取环境（配置文件属性）, IOC容器， classLoader对象等等
     * @param metadata 注解元对象。 可以获取注解定义的属性值
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 通过注解属性值， 动态判断 某个依赖（包） 是否引入了
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionOnClass.class.getName());
        if (annotationAttributes == null) {
            return false;
        }

        String[] value = (String[]) annotationAttributes.getOrDefault("value", new String[0]);

        boolean flag = true;
        for (String className : value) {
            try {
                Class.forName(className);
            } catch (ClassNotFoundException e) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
