package org.github.chapter02;


/**
 * @author hewenji
 * @Date 2022/9/3 23:33
 */
public class HelloClassLoader {
    public static void main(String[] args) {
        // HelloClassLoader 的类加载器sun.misc.Launcher$AppClassLoader@18b4aac2  (系统类加载器或者说是应用类加载器)
        System.out.println("HelloClassLoader 的类加载器" + HelloClassLoader.class.getClassLoader());

        System.out.println(Thread.currentThread().getContextClassLoader());

    }
}
