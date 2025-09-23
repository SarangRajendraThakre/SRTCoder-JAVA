package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class P1_lock_lock {

    // The lock is an instance variable, which is correct.
    private final Lock myLock = new ReentrantLock();

    // Move the locking logic into a method.
    public void performTask() {
        myLock.lock(); // Acquire the lock
        try {
            // Your critical section code goes here...
            // This is the code you want to protect from
            // being accessed by multiple threads at once.
            System.out.println(Thread.currentThread().getName() + " is performing the task.");
        } finally {
            myLock.unlock(); // Release the lock
        }
    }

    public static void main(String[] args) {
        // You can now create an instance and call the method.
        P1_lock_lock example = new P1_lock_lock();
        
        // Example of how to use it with threads
        Runnable task = () -> {
            example.performTask();
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }
}