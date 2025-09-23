public class PerspectiveExample {
    public static void main(String[] args) throws InterruptedException {

        Thread workerThread = new Thread(() -> {
            // PERSPECTIVE 1: INSIDE THE WORKER
            // The worker checks its own status repeatedly without changing it.
            while (!Thread.currentThread().isInterrupted()) {
                // Keep working...
            }
            System.out.println("Worker: My interrupted status is now TRUE, so I'm stopping.");
        });

        workerThread.start();
        Thread.sleep(100); // Let the worker run

        // PERSPECTIVE 2: OUTSIDE THE WORKER
        // The main thread checks the worker's status.
        System.out.println("Main: Is the worker interrupted? -> " + workerThread.isInterrupted()); // false

        System.out.println("Main: Sending interrupt signal.");
        workerThread.interrupt(); // Now the worker's flag is true
        Thread.sleep(100); // Give worker time to exit its loop

        System.out.println("Main: Is the worker interrupted now? -> " + workerThread.isInterrupted()); // true
    }
}