package com.github.demo.construtorbinding;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        try {
            bind(TransactionLog.class).toConstructor(
                    DatabaseTransactionLog.class.getConstructor(DatabaseConnection.class));
        } catch (NoSuchMethodException e) {
            addError(e);
        }
    }
}