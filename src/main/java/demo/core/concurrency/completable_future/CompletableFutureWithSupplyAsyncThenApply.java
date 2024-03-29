package demo.core.concurrency.completable_future;

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/3/19.
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

class MathUtil {
    public static int times(int number, int times) {
        return number * times;
    }

    public static int squared(int number) {
        return number * number;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

public class CompletableFutureWithSupplyAsyncThenApply {

    public static final int NUMBER = 5;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a CompletableFuture
        CompletableFuture<Integer> times2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return MathUtil.times(NUMBER, 2);
        });

        // Attach a callback to the Future using thenApply()
        CompletableFuture<Boolean> greetingFuture = times2.thenApply(n -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return MathUtil.squared(n);
        })
                // Chaining multiple callbacks
                .thenApply(n -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return MathUtil.isEven(n);
                });

        // Block and get the result of the future.
        System.out.println(greetingFuture.get()); // true
    }
}
