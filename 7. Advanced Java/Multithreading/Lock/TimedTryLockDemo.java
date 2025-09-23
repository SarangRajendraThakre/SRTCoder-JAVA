package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TimedTryLockDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        // First thread takes the lock and holds it for a while
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1 acquired the lock and will hold it for 5 seconds.");
                Thread.sleep(5000); // Hold the lock for 5 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("Thread 1 is releasing the lock.");
                lock.unlock();
            }
        }).start();

        // Give the first thread a moment to start and acquire the lock
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Second thread tries to acquire the lock, but will only wait for 2 seconds
        new Thread(() -> {
            System.out.println("Thread 2 is attempting to acquire the lock (will wait for 2 seconds)...");
            boolean acquired = false;
            try {
                // This will wait for a maximum of 2 seconds
                acquired = lock.tryLock(2, TimeUnit.SECONDS);

                if (acquired) {
                    System.out.println("Thread 2 acquired the lock!");
                    // ... do work ...
                } else {
                    System.out.println("Thread 2 could not acquire the lock within 2 seconds. Giving up.");
                }

            } catch (InterruptedException e) {
                System.out.println("Thread 2 was interrupted while waiting.");
                Thread.currentThread().interrupt();
            } finally {
                // Only unlock if the lock was actually acquired
                if (acquired) {
                    lock.unlock();
                }
            }
        }).start();
    }
}