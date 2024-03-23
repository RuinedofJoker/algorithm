package juc;

import java.util.concurrent.locks.ReentrantLock;

public class TwoPhaseTerminationPatter {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("释放资源");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    //Thread.sleep(0);
                } catch (InterruptedException e) {
                    System.out.println("线程睡眠状态被打断");
                    Thread.currentThread().interrupt();
                }
            }
        }, "t1");

        Thread monitor = new Thread(() -> {
            try {
                Thread.sleep(1000);
                t1.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "monitor");

        t1.start();
        monitor.start();

    }
}
