package juc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

//自定义不可重入锁
@Slf4j
@Data
public class MyLock implements Lock {

    public static void main(String[] args) {
        MyLock lock = new MyLock();

        //ExecutorService threadPool = Executors.newCachedThreadPool(); 该线程池使用无容量队列,每有一个新任务没有空闲线程都会新建一个线程处理

        //该线程池使用无界队列,每有一个新任务没有空闲线程都会加入到该队列中
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                lock.lock();
                try {
                    log.debug("locking...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    log.debug("unlocking...");
                    lock.unlock();
                }
            });
        }

        threadPool.shutdown();
    }

    class MySync extends AbstractQueuedSynchronizer {

        //AbstractQueuedSynchronizer内有个变量state,为1代表有线程加锁成功,为0代表没有线程上锁
        @Override
        protected boolean tryAcquire(int arg) {
            //用cas保证status变量的线程安全
            if (compareAndSetState(0, 1)) {
                //加锁成功,设置 owner 为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        //是否持有独占锁
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }
    }

    private MySync sync = new MySync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
