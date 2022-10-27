package com.github.demo.linkedbinding;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class BillingModule extends AbstractModule {
    @Provides
    TransactionLog provideTransactionLog(DatabaseTransactionLog impl) {
        return impl;
    }

    @Provides
    DatabaseTransactionLog provideDatabaseTransactionLog(MySqlDatabaseTransactionLog impl) {
        return impl;
    }

    @Provides
    MySqlDatabaseTransactionLog provideDatabaseTransactionLog() {
        return new MySqlDatabaseTransactionLog();
    }

}