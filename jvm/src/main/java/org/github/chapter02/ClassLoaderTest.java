package org.github.chapter02;

import com.sun.java.accessibility.AccessBridge;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author hewenji
 * @Date 2022/9/4 9:11
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2
//        System.out.println("AppClassLoader 由" + systemClassLoader.getClass().getClassLoader() + "加载");

        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader); // sun.misc.Launcher$ExtClassLoader@1b6d3586
//        System.out.println("AppClassLoader 由" + extClassLoader.getClass().getClassLoader() + "加载");

        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);  // null

        System.out.println(ClassLoaderTest.class.getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2

        // Java的核心内库都是由引导类加载器进行加载的
        System.out.println(String.class.getClassLoader());  // null

        System.out.println(AccessBridge.class.getClassLoader());  // sun.misc.Launcher$ExtClassLoader@1b6d3586


    }
}
