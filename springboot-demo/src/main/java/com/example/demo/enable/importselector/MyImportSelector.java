package com.example.demo.enable.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author hewenji
 * @Date 2023/7/16 17:46
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        // 这里要加载的类就不是写的的了，因为他是字符串类型， 所以可以动态的读配置文件
        return new String[]{"com.example.demo.enable.pojo.Person", "com.example.demo.enable.pojo.Role"};
    }
}
