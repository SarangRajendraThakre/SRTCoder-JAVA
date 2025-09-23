public class InterruptedExample {
    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            System.out.println("Worker started. isInterrupted: " + Thread.currentThread().isInterrupted());

            // The main thread will interrupt this thread while it's running
            while (System.currentTimeMillis() < Long.MAX_VALUE); // Busy wait
        });

        worker.start();
        Thread.sleep(100); // Give the worker a moment to start

        // Signal the worker to stop
        worker.interrupt();
        Thread.sleep(100); // Give the worker a moment to receive the signal

        System.out.println("1. Checking status: worker.isInterrupted() -> " + worker.isInterrupted());

        // Now, let's imagine the worker thread checks its own status using Thread.interrupted()
        // We can't do that directly, but we can see the effect.
        // If the worker called Thread.interrupted(), it would get true, and the flag would clear.

        // Let's simulate a second check, which would happen after a Thread.interrupted() call
        // Because Thread.interrupted() clears the flag, a subsequent check on the flag will be false.
        // A direct call to Thread.interrupted() would clear the flag.
        // Let's demonstrate with a runnable that does this.

        Thread clearingWorker = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                // Wait for interruption
            }
            System.out.println("A. Worker interrupted! Status before check: " + Thread.currentThread().isInterrupted());
            // Check and CLEAR the flag
            boolean wasInterrupted = Thread.interrupted();
            System.out.println("B. Thread.interrupted() returned: " + wasInterrupted);
            System.out.println("C. Status after check: " + Thread.currentThread().isInterrupted());
        });

        clearingWorker.start();
        Thread.sleep(100);
        clearingWorker.interrupt();
    }
}