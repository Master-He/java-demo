package org.github.chapter02;

import com.sun.java.accessibility.AccessBridge;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author hewenji
 * @Date 2022/9/4 9:11
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {

        System.out.println("=========================启动类加载器的加载路径=========================");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }

        System.out.println("=========================扩展类加载器的加载路径=========================");
        urls = ((URLClassLoader) ClassLoader.getSystemClassLoader().getParent()).getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }


        System.out.println("\n =========================扩展类加载器的加载目录=========================");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }

        System.out.println("\n =========================应用类加载器的加载目录=========================");
        String appPath = System.getProperty("java.class.path");
        for (String path : appPath.split(";")) {
            System.out.println(path);
        }

    }
}
