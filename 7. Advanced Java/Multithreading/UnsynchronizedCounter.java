public class UnsynchronizedCounter {
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