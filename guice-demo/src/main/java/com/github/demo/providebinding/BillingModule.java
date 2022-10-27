package com.github.demo.providebinding;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TransactionLog.class)
                .toProvider(DatabaseTransactionLogProvider.class);
    }
}