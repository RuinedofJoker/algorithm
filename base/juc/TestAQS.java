package juc;

import java.util.concurrent.locks.ReentrantLock;

public class TestAQS {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
