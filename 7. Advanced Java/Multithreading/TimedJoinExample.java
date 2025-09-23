public class TimedJoinExample {
    public static void main(String[] args) throws InterruptedException {

        Thread workerThread = new Thread(() -> {
            try {
                System.out.println("Worker: I'm starting my long task...");
                Thread.sleep(1000); // Simulate 1 second of work
                System.out.println("Worker: I'm finally done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        workerThread.start();

        System.out.println("Main: I will wait for the worker, but only for 200ms.");
        workerThread.join(200); // Wait for a maximum of 200 milliseconds

        // This line will be reached after ~200ms
        System.out.println("Main: My wait is over.");

        if (workerThread.isAlive()) {
            System.out.println("Main: The worker is still running in the background.");
        } else {
            System.out.println("Main: The worker finished before my timeout.");
        }
    }
}