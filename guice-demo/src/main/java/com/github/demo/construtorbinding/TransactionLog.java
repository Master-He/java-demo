package com.github.demo.construtorbinding;

/**
 * @author hwj20715
 * @version 1.0
 * @date 2022/10/27 11:13
 */
public abstract class TransactionLog {

    abstract DatabaseConnection getConnection();
}
