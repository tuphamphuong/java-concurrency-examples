package demo.core.concurrency.synchronition;

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/1/19.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SynchronizedBlockCounter {
    private int count = 0;

    // Synchronized Method
    public void increment() {
        synchronized (this) {
            count = count + 1;
        }
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizedBlockExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        SynchronizedBlockCounter synchronizedCounter = new SynchronizedBlockCounter();

        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> synchronizedCounter.increment());
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Final count is : " + synchronizedCounter.getCount());
    }
}
