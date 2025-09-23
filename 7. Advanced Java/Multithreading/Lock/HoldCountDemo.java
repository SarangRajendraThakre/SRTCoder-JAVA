package Lock;

import java.util.concurrent.locks.ReentrantLock;

public class HoldCountDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        // The current thread does not hold the lock yet.
        System.out.println("Hold count before locking: " + lock.getHoldCount());

        // First lock
        lock.lock();
        System.out.println("Hold count after first lock: " + lock.getHoldCount());

        // Second lock (reentrant)
        lock.lock();
        System.out.println("Hold count after second lock: " + lock.getHoldCount());

        // First unlock
        lock.unlock();
        System.out.println("Hold count after first unlock: " + lock.getHoldCount());

        // Second unlock
        lock.unlock();
        System.out.println("Hold count after second unlock: " + lock.getHoldCount());
    }
}