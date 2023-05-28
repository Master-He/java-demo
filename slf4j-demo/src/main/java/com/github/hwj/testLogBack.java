package com.github.hwj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hewenji
 * @Date 2023/5/28 23:38
 */
public class testLogBack {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(testSlf4j.class);
        logger.info("Hello World");
    }
}
