package Lock;

import java.util.concurrent.locks.ReentrantLock;

public class FairAndQueueLengthDemo {

    public static void main(String[] args) throws InterruptedException {
        // Create one of each type of lock
        ReentrantLock fairLock = new ReentrantLock(true);
        ReentrantLock nonFairLock = new ReentrantLock(false);

        // --- Demonstrating isFair() ---
        System.out.println("Checking fairness policies:");
        System.out.println("Is fairLock fair? " + fairLock.isFair());       // true
        System.out.println("Is nonFairLock fair? " + nonFairLock.isFair()); // false
        System.out.println("------------------------------------");

        // --- Demonstrating getQueueLength() ---
        // Main thread acquires the lock
        fairLock.lock();
        System.out.println("Main thread has acquired the lock.");

        // Create 3 worker threads that will wait for the lock
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is trying to acquire the lock.");
            fairLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " has acquired the lock.");
            } finally {
                fairLock.unlock();
            }
        };

        Thread t1 = new Thread(task, "Worker-1");
        Thread t2 = new Thread(task, "Worker-2");
        Thread t3 = new Thread(task, "Worker-3");

        t1.start();
        t2.start();
        t3.start();

        // Give the threads time to start and get blocked
        Thread.sleep(1000);

        // Check the queue length from the main thread
        System.out.println("\nMain thread checks queue length: " + fairLock.getQueueLength()); // Should be 3
        
        // Release the lock so the other threadfffs can proceed
        System.out.println("Main thread is releasing the lock.");
        fairLock.unlock();

    }
}
