package com.github.demo.providebinding;

/**
 * @author hwj20715
 * @version 1.0
 * @date 2022/10/27 11:13
 */
public abstract class TransactionLog {

    abstract void setConnection(Connection connection);

    abstract Connection getConnection();
}
