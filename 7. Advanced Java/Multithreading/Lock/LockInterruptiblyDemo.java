package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyDemo {

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();

        // Thread-1 acquires the lock and holds it
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread-1 holds the lock and is sleeping for 5 seconds...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Thread-1 is releasing the lock.");
                lock.unlock();
            }
        }, "Thread-1");

        // Thread-2 tries to acquire the lock interruptibly
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("Thread-2 is trying to acquire the lock...");
                lock.lockInterruptibly(); // This thread will wait here
                try {
                    System.out.println("Thread-2 acquired the lock.");
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                System.out.println("Thread-2 was interrupted while waiting for the lock. It will not acquire the lock.");
            }
        }, "Thread-2");

        thread1.start();
        // Give Thread-1 a moment to acquire the lock
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        thread2.start();
        // Give Thread-2 a moment to start waiting
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        // Now, from the main thread, interrupt Thread-2
        System.out.println("Main thread is interrupting Thread-2.");
        thread2.interrupt();
    }
}