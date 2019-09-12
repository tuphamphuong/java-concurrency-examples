package demo.core.concurrency.fork_join.recursivetask;

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/3/19.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(ForkJoinAdd.startForkJoinSum(1_000_000));

    }

}
