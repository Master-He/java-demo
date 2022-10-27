package com.github.demo.construtorbinding;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author hwj20715
 * @version 1.0
 * @date 2022/10/27 14:44
 */
public class ConstructorBindingTest {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BillingModule());
        TransactionLog instance = injector.getInstance(TransactionLog.class);

        System.out.println(instance.getConnection().getName());
    }
}
