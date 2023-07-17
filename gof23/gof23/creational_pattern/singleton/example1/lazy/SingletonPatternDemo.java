package gof23.creational_pattern.singleton.example1.lazy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                SingleObject instance = SingleObject.getInstance();
                instance.showMessage();
                System.out.println(instance);
            });
        }

        threadPool.shutdown();
    }
}
