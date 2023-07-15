package org.github.juc;

import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @author hewenji
 * @Date 2023/6/24 22:15
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Void> future  = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111111111111");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return "HELLO";
            }
        });


        System.out.println(future.get());
        System.out.println(future2.get());
    }
}
