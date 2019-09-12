package demo.core.concurrency.completable_future;

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/3/19.
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class MailUtil {
    public static String getMailInfo() {
        return "Your email content";
    }

    public static boolean sendMail() {
        System.out.println("Send mail: completed");
        return true;
    }

    public static void logging() {
        System.out.println("Log: Send mail at " + System.currentTimeMillis());
    }
}

public class CompletableFutureWithSupplyAsyncThenAcceptThenRun {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // thenAccept() example
        CompletableFuture.supplyAsync(() -> {
            return MailUtil.getMailInfo();
        }).thenAccept(content -> {
            System.out.println("Mail content: " + content);
        });

        // thenRun() example
        CompletableFuture.supplyAsync(() -> {
            return MailUtil.sendMail();
        }).thenRun(() -> {
            MailUtil.logging();
        });
    }
}
