package org.github.juc;


/**
 * @author hewenji
 * @Date 2022/8/10 20:55
 *  * 线程之间的通信问题： 生产者和消费者问题！ 等待环形， 通知唤醒
 *  * 线程交替执行   A B 操作同一个变量 num = 0
 *  * A num + 1
 *  * B num - 1
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        Data data = new Data();

        Runnable runnable1 = () -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = () -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        System.out.println("===");

        new Thread(runnable1, "A").start();
        new Thread(runnable1, "B").start();
        new Thread(runnable2, "C").start();
        new Thread(runnable2, "D").start();

    }

    private static class Data {
        private int num = 0;

        public synchronized void increment() throws InterruptedException {
            while (num >= 1) {
                this.wait();
                System.out.println(Thread.currentThread().getName() + "被唤醒了");
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "==>" + num);
            // 通知其他this锁等待的线程， 我+1完毕了
            this.notifyAll();
        }

        public synchronized void decrement() throws InterruptedException {
            while (num <= 0) {
                this.wait();
                System.out.println(Thread.currentThread().getName() + "被唤醒了");
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "==>" + num);
            // 通知其他this锁等待的线程， 我-1完毕了
            this.notifyAll();
        }
    }
}
