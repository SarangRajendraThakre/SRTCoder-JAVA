import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBuffer {
    private final Queue<Object> buffer = new LinkedList<>();
    private final int capacity;
    private final Lock lock = new ReentrantLock();

    // 1. Create a condition for when the buffer is NOT full
    private final Condition notFull = lock.newCondition();

    // 2. Create a separate condition for when the buffer is NOT empty
    private final Condition notEmpty = lock.newCondition();

    public BoundedBuffer(int capacity) { this.capacity = capacity; }

    public void put(Object item) throws InterruptedException {
        lock.lock();
        try {
            while (buffer.size() == capacity) {
                // Buffer is full, wait in the "notFull" room
                notFull.await();
            }
            buffer.add(item);
            // Signal a thread in the "notEmpty" room that an item is available
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (buffer.isEmpty()) {
                // Buffer is empty, wait in the "notEmpty" room
                notEmpty.await();
            }
            Object item = buffer.remove();
            // Signal a thread in the "notFull" room that space is available
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }
}