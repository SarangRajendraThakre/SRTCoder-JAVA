// This class is thread-safe because the increment() method is synchronized.
class Counter {
     static int count = 0;

    // Only one thread can execute this method at a time on a single Counter instance.
    public synchronized static void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}


class UnsynchronizedCounter {
    private int count = 0;

    public void performLongTaskAndIncrement() {
        try {
            System.out.println(Thread.currentThread().getName() + " is performing a long task...");
            Thread.sleep(1000); // This part is NOT synchronized.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Only the critical section is locked.
        synchronized (this) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + " finished. Count is now: " + count);
    }
}

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {



        Counter counter = new Counter();

        UnsynchronizedCounter us1 = new UnsynchronizedCounter();
        UnsynchronizedCounter us2 = new UnsynchronizedCounter();

        // Create two threads that will both increment the same counter instance.
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Counter.increment();
            }
        });

        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // The final count will always be 2000 because of synchronization.
        System.out.println("Final count: " + counter.getCount() );



        
    }
}