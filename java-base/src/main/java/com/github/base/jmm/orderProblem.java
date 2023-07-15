package com.github.base.jmm;

import java.util.HashSet;

/**
 * @author hewenji
 * @Date 2023/5/24 22:21
 */
public class orderProblem {
    private static int x = 0;
    private static int y = 0;
    private static int a = 0;
    private static int b = 0;


    public static void main(String[] args) throws InterruptedException {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 1000000; i++) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(()->{
                a = y;  // 指令顺序不保证
                x = 1;
            });

            Thread other = new Thread(()->{
                b = x;
                y = 1;
            });

            one.start();
            other.start();
            one.join();
            other.join();

            set.add("a="+a+",b="+b);
            System.out.println(set);  // 会出现这种情况 [a=0,b=0, a=1,b=0, a=0,b=1, a=1,b=1]
        }



    }
}
