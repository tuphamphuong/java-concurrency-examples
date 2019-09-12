package demo.core.concurrency.executor_service;

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/1/19.
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            System.out.println("Executing Task At " + System.nanoTime());
        };

        System.out.println("Submitting task at " + System.nanoTime() + " to be executed after 5 seconds.");
        scheduledExecutorService.schedule(task, 5, TimeUnit.SECONDS);
        // Or Period
        // scheduledExecutorService.scheduleAtFixedRate(task, 0,2, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }
}
