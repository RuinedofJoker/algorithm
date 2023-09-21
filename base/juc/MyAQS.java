package juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class MyAQS {
    private AtomicInteger state;
    private Thread holdThread;
    private Node head;
    private Node tail;

    public MyAQS() {
        state = new AtomicInteger(0);
        head = new Node(null);
        head.isHead = true;
        tail = new Node(null);
        tail.isTail = true;
        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;
    }

    public void unLock() {
        if (holdThread == Thread.currentThread()) {
            state.compareAndSet(1, 0);
            awakenAll();
        }
    }

    public boolean tryLock(long waitTime) throws InterruptedException {

        Thread currentThread = Thread.currentThread();
        long currentTime = System.currentTimeMillis();
        long remainTime = waitTime;

        boolean isLocked = state.compareAndSet(0, 1);
        if (isLocked) {
            holdThread = currentThread;
            return true;
        }
        addQueueTail(currentThread);

        LockSupport.parkNanos(remainTime * 1000);

        while (true) {
            long passTime = System.currentTimeMillis() - currentTime;
            if (passTime > remainTime) {
                return false;
            }
            isLocked = state.compareAndSet(0, 1);
            if (isLocked) {
                holdThread = currentThread;
                return true;
            }
            remainTime = remainTime - passTime;
            currentTime = System.currentTimeMillis();

            LockSupport.parkNanos(remainTime * 1000);
        }
    }

    private void addQueueTail(Thread currentThread) {
        Node currentNode = new Node(currentThread);
        tail.prev.next = currentNode;
        currentNode.prev = tail.prev;
        tail.prev = currentNode;
        currentNode.next = tail;
    }

    public void awakenAll() {
        head.awaken();
        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;
    }

    public static void main(String[] args) {

        Thread[] threads = new Thread[10];
        MyAQS myAQS = new MyAQS();
        AtomicInteger integer = new AtomicInteger(0);

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                try {
                    boolean lock = myAQS.tryLock(integer.incrementAndGet() * 1000);
                    System.out.println(Thread.currentThread().getName() + "   " + lock);
                    if (lock) {
                        Thread.sleep(1000);
                        myAQS.unLock();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }

    static class Node {
        public Node(Thread thread) {
            this.thread = thread;
        }

        public void awaken() {
            if (!isHead && !isTail) {
                LockSupport.unpark(thread);
            }
            if (!next.isTail) {
                next.awaken();
            }
        }

        private boolean isHead = false;
        private boolean isTail = false;
        private Node prev;
        private Node next;
        private final Thread thread;
    }
}
