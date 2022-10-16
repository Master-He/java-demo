package org.github.jstat;

import java.util.ArrayList;

/**
 * @author hewenji
 * @Date 2022/10/12 0:39
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8
 */
public class JstatTest {
    // OOM test
    public static void main(String[] args) {
        ArrayList<byte[]> lists = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            byte[] arr = new byte[1024 * 100];
            lists.add(arr);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
