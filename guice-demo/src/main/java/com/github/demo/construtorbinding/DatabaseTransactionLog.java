package com.github.demo.construtorbinding;

/**
 * @author hwj20715
 * @version 1.0
 * @date 2022/10/27 14:38
 */
public class DatabaseTransactionLog extends TransactionLog {
    public DatabaseConnection connection;

    public DatabaseTransactionLog() {
    }

    public DatabaseTransactionLog(DatabaseConnection connection) {
        this.connection = connection;
    }

    public DatabaseConnection getConnection() {
        return connection;
    }
}
