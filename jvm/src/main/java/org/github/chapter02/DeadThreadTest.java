package org.github.chapter02;

/**
 * @author hewenji
 * @Date 2022/9/4 1:36
 */
public class DeadThreadTest {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "开始加载");
            DeadThreat deadThreat = new DeadThreat();
            System.out.println(Thread.currentThread().getName() + "结束加载");
        };

        // 第二个线程想要运行<clinit>方法，需要等待第一个线程运行完<clinit>方法，才能运行。 因为运行<clinit>方法会加锁
        Thread t1 = new Thread(runnable, "线程1");
        Thread t2 = new Thread(runnable, "线程2");

        t1.start();
        t2.start();

    }
}

class DeadThreat {
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + "初始化当前类");
            while (true) {

            }
        }
    }
}
