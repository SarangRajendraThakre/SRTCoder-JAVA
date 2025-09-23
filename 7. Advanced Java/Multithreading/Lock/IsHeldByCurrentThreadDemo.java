package Lock;

import java.util.concurrent.locks.ReentrantLock;

public class IsHeldByCurrentThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();

        // Check status from the main thread before locking
        System.out.println("Main thread holds lock before locking: " + lock.isHeldByCurrentThread()); // false

        // A new thread that will acquire the lock
        Thread workerThread = new Thread(() -> {
            System.out.println("Worker thread about to lock...");
            lock.lock();
            try {
                // Check status from WITHIN the thread that holds the lock
                System.out.println("Worker thread holds lock: " + lock.isHeldByCurrentThread()); // true
            } finally {
                lock.unlock();
                System.out.println("Worker thread released lock.");
            }
        });

        workerThread.start();
        workerThread.join(); // Wait for the worker thread to finish

        // Check status from the main thread after the worker is done
        System.out.println("Main thread holds lock after worker is done: " + lock.isHeldByCurrentThread()); // false
    }
}