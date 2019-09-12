package demo.core.concurrency.fork_join.recursiveaction;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/3/19.
 */
public class Main {

    public static void main(String[] args) {

        ForkJoinFibonacci task = new ForkJoinFibonacci(50);
        new ForkJoinPool().invoke(task);

        System.out.println(task.getNumber());

    }

}
