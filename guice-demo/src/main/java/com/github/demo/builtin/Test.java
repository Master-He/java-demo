package com.github.demo.builtin;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author hwj20715
 * @version 1.0
 * @date 2022/10/27 15:05
 */
public class Test {
    public static void main(String[] args) {
        // Logger 是内置的，所以不用声明module
        Injector injector = Guice.createInjector();
        ConsoleTransactionLog instance = injector.getInstance(ConsoleTransactionLog.class);

        instance.logConnectException(new Exception("123"));
    }
}
