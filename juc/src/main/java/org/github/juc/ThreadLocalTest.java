package org.github.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hewenji
 * @Date 2022/8/11 22:47
 */
public class ThreadLocalTest {
    public static ThreadLocal<List<Integer>> intListThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            if (intListThreadLocal.get() == null) {
               intListThreadLocal.set(new ArrayList<>());
            }
            for (int i = 0; i < 10; i++) {
                intListThreadLocal.get().add(i);
            }
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ==> " +intListThreadLocal.get());
        }, "A").start();


        new Thread(() -> {
            if (intListThreadLocal.get() == null) {
                intListThreadLocal.set(new ArrayList<>());
            }
            for (int i = 90; i < 100; i++) {
                intListThreadLocal.get().add(i);
            }
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ==> " +intListThreadLocal.get());
        }, "B").start();

        if (intListThreadLocal.get() == null) {
            intListThreadLocal.set(new ArrayList<>());
        }
        Thread.sleep(3);
        System.out.println(Thread.currentThread().getName() + " ==> " +intListThreadLocal.get());
    }
}
