package com.github.base.jmm;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hewenji
 * @Date 2023/5/25 8:00
 */
public class ThreadImplement {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();


    }
}
