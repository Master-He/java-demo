package org.github.chapter03;

/**
 * @author hewenji
 * @Date 2022/9/4 20:28
 */


public class PCRegisterTest {
    /**
     * 反编译class文件后看具体的偏移量
     */
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        int k = i + j;

        String s = "abc";
        System.out.println(i);
        System.out.println(k);
    }
}
