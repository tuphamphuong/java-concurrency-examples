package demo.core.concurrency.future;

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/1/19.
 */

import java.util.Arrays;
import java.util.concurrent.*;

public class InvokeAnyExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(5000);
            return "Result of Task3";
        };

        // Returns the result of the fastest callable. (task2 in this case)
        String result = executorService.invokeAny(Arrays.asList(task1, task2, task3));

        System.out.println(result);

        executorService.shutdown();
    }
}