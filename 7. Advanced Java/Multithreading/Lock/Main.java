package Lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. The BoundedBuffer (Shared Resource)
 * This class represents a thread-safe buffer with a fixed size.
 */
class BoundedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity;
    private final Lock lock = new ReentrantLock();

    // Condition for when the buffer is NOT full
    private final Condition notFull = lock.newCondition();

    // Condition for when the buffer is NOT empty
    private final Condition notEmpty = lock.newCondition();

    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Adds an item to the buffer. If the buffer is full, it waits.
     * @param item The integer item to add.
     */
    public void put(int item) throws InterruptedException {
        lock.lock();
        try {
            // Wait while the buffer is full
            while (buffer.size() == capacity) {
                System.out.println("Buffer is full. Producer is waiting...");
                notFull.await();
            }
            buffer.add(item);
            System.out.println("-> Produced: " + item + " [Buffer size: " + buffer.size() + "]");
            // Signal to any waiting consumers that an item is now available
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Takes an item from the buffer. If the buffer is empty, it waits.
     * @return The integer item removed.
     */
    public int take() throws InterruptedException {
        lock.lock();
        try {
            // Wait while the buffer is empty
            while (buffer.isEmpty()) {
                System.out.println("Buffer is empty. Consumer is waiting...");
                notEmpty.await();
            }
            int item = buffer.remove();
            System.out.println("<- Consumed: " + item + " [Buffer size: " + buffer.size() + "]");
            // Signal to any waiting producers that space is now available
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 2. The Producer Runnable
 * This task continuously adds items to the buffer.
 */
class Producer implements Runnable {
    private final BoundedBuffer buffer;

    public Producer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                buffer.put(i);
                // Simulate time taken to produce an item
                Thread.sleep((long) (Math.random() * 200));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * 3. The Consumer Runnable
 * This task continuously takes items from the buffer.
 */
class Consumer implements Runnable {
    private final BoundedBuffer buffer;

    public Consumer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                buffer.take();
                // Simulate time taken to consume an item
                Thread.sleep((long) (Math.random() * 500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * 4. The Main Class
 * Sets up and starts the producer and consumer threads.
 */
public class Main {
    public static void main(String[] args) {
        // Create a shared buffer with a capacity of 5
        BoundedBuffer buffer = new BoundedBuffer(5);

        // Create one producer and one consumer
        Producer producerTask = new Producer(buffer);
        Consumer consumerTask = new Consumer(buffer);

        Thread producerThread = new Thread(producerTask);
        Thread consumerThread = new Thread(consumerTask);

        System.out.println("Starting Producer-Consumer simulation...");
        producerThread.start();
        consumerThread.start();
    }
}