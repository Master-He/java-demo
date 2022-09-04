package org.github.chapter01;

/**
 * @author hewenji
 * @Date 2022/9/3 23:04
 */
public class Main {
    private static int a = 100;

    static {
        a = 200;
        number = 1;
    }

    private static int number = 555;

    private int var;

    public Main() {
        var = 1;
    }

    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        System.out.println(i + j);

        System.out.println(a);
        System.out.println(number);
    }
}
