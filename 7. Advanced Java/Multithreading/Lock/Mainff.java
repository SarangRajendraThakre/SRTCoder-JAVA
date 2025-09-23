package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. The SharedResource
 * Manages the shared state and the lock/condition for coordination.
 */
class SharedResource {
    private final Lock lock = new ReentrantLock();
    private final Condition canProceed = lock.newCondition();
    private boolean isReady = false;

    /**
     * Workers call this method. They will wait until the producer gives the signal.
     */
    public void awaitSignal() {
        lock.lock();
        try {
            while (!isReady) {
                System.out.println(Thread.currentThread().getName() + " is waiting for the signal...");
                canProceed.await();
            }
            // Once awoken, the worker can proceed
            System.out.println(Thread.currentThread().getName() + " received the signal and is proceeding!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    /**
     * The producer calls this method to wake up all waiting workers.
     */
    public void giveSignal() {
        lock.lock();
        try {
            System.out.println(">>> PRODUCER: The resource is now ready. Signaling all workers.");
            this.isReady = true;
            // Wake up ALL threads waiting on the 'canProceed' condition
            canProceed.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 2. The Worker (Consumer) Runnable
 */
class Worker implements Runnable {
    private final SharedResource resource;

    public Worker(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.awaitSignal();
    }
}

/**
 * 3. The Producer Runnable
 */
class Producer implements Runnable {
    private final SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            // Simulate some time to prepare the resource
            Thread.sleep(2000);
            resource.giveSignal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * 4. The Main Class to Run the Demonstration
 */
public class Mainff {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Create 3 worker threads (consumers)
        Thread worker1 = new Thread(new Worker(resource), "Worker-1");
        Thread worker2 = new Thread(new Worker(resource), "Worker-2");
        Thread worker3 = new Thread(new Worker(resource), "Worker-3");

        // Create 1 producer thread
        Thread producer = new Thread(new Producer(resource));

        System.out.println("Starting workers and producer...");

        worker1.start();
        worker2.start();
        worker3.start();
        producer.start();
    }
}