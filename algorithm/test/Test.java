package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        CollegiateEntrance collegiateEntrance = new CollegiateEntrance();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000000; i++) {
            threadPool.execute(() -> {
                try {
                    collegiateEntrance.enterSchool();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        threadPool.shutdown();
    }
    static class CollegiateEntrance {
        private Semaphore semaphore = new Semaphore(50000, true);
        private AtomicInteger numberInSchool = new AtomicInteger(0);
        private AtomicInteger ranking = new AtomicInteger(0);

        public void enterSchool() throws InterruptedException {
            semaphore.acquire();
            int currentNum = numberInSchool.incrementAndGet();
            int rank = ranking.incrementAndGet();
            System.out.println("第" + rank + "个人进入学校,当前学校里有" + currentNum + "人");
            currentNum = numberInSchool.decrementAndGet();
            System.out.println("第" + rank + "个人离开学校,当前学校里有" + currentNum + "人");
            semaphore.release();
        }
    }
}
