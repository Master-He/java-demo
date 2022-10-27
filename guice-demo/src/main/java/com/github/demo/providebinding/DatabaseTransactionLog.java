package com.github.demo.providebinding;

/**
 * @author hwj20715
 * @version 1.0
 * @date 2022/10/27 14:38
 */
public class DatabaseTransactionLog extends TransactionLog {
    public Connection connection;

    @Override
    void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    Connection getConnection() {
        return connection;
    }
}
