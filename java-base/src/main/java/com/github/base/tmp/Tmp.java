package com.github.base.tmp;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author hewenji
 * @Date 2023/6/20 0:02
 */
public class Tmp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 没有返回值的runAsync 异步回调
        Future<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " runAsync => Void");

        });

        System.out.println(Thread.currentThread().getName());
        // System.out.println("如果主线程也sleep 5秒，获取结果就不会阻塞，因为子线程已经sleep 5秒了， 这就是异步调用");
        future.get();   // 获取阻塞执行结果
    }
}
