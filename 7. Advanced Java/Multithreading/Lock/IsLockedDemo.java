package Lock;

import java.util.concurrent.locks.ReentrantLock;

public class IsLockedDemo {

    public static void main(String[] args) throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();

        // Check status before any thread has locked it
        System.out.println("Is lock busy before start? " + lock.isLocked()); // false

        // A new thread that will acquire and hold the lock for a short time
        Thread workerThread = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Worker thread has acquired the lock.");
                Thread.sleep(2000); // Hold the lock for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("Worker thread has released the lock.");
            }
        });

        workerThread.start();
        Thread.sleep(500); // Give the worker time to acquire the lock

        // Check status from the main thread while the worker thread holds it
        System.out.println("Is lock busy while worker holds it? " + lock.isLocked()); // true

        workerThread.join(); // Wait for the worker thread to finish completely

        // Check status from the main thread after the worker has released it
        System.out.println("Is lock busy after worker is done? " + lock.isLocked()); // false
    }
}