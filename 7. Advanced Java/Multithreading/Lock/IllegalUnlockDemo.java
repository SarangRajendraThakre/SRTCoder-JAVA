package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IllegalUnlockDemo {
    public static void main(String[] args) {
        Lock myLock = new ReentrantLock();

        System.out.println("Attempting to unlock a lock that is not held...");

        try {
            // This line will throw the exception because the main thread
            // does not own the lock.
            myLock.unlock();
        } catch (IllegalMonitorStateException e) {
            System.err.println("\nCaught the exception as expected!");
            System.err.println(e);
        }
    }
}