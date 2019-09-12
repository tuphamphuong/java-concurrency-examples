package demo.core.concurrency.lock;

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/1/19.
 */

import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockCounter {
    private final ReentrantLock lock = new ReentrantLock();

    private int count = 0;

    // Thread Safe Increment
    public void increment() {
        lock.lock();
        try {
            count = count + 1;
        } finally {
            lock.unlock();
        }
    }
}
