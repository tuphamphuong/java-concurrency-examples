package demo.core.concurrency.synchronition;

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/1/19.
 */
public class VolatileKeywordExample {
    private static volatile boolean sayHello = false;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (!sayHello) {
            }

            System.out.println("Hello World!");

            while (sayHello) {
            }

            System.out.println("Good Bye!");
        });

        thread.start();

        Thread.sleep(1000);
        System.out.println("Say Hello..");
        sayHello = true;

        Thread.sleep(1000);
        System.out.println("Say Bye..");
        sayHello = false;
    }
}
