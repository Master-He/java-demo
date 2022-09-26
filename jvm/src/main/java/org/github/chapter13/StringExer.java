package org.github.chapter13;

import java.util.HashMap;
import java.util.Hashtable;

public class StringExer {
    String str = new String("good");
    char [] ch = {'t','e','s','t'};

    public void change(String str, char ch []) {
        str = "test ok";  // 因为传递到方法里面的参数是一个引用，string的不可变性，change方法会重新申请新的内存空间和引用, 所以改不了实例变量
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringExer ex = new StringExer();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);  // good
        System.out.println(ex.ch);  // best
    }
}