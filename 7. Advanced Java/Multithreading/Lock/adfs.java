package Lock;

 import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class DataStore {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    // Get the two separate locks from the main ReadWriteLock
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public String readData() {
        readLock.lock(); // Multiple threads can enter here
        try {
            // ... read from the shared resource
            return "some data";
        } finally {
            readLock.unlock();
        }
    }

    public void writeData(String data) {
        writeLock.lock(); // Only one thread can enter here
        try {
            // ... write to the shared resource
        } finally {
            writeLock.unlock();
        }
    }
}