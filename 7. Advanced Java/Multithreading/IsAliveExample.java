public class IsAliveExample {
    public static void main(String[] args) throws InterruptedException {

        Thread workerThread = new Thread(() -> {
            System.out.println("Worker: I am starting my task.");
            try {
                Thread.sleep(1000); // Simulate 1 second of work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker: I have finished my task.");
        });

        // 1. Before starting the thread
        System.out.println("Before start(), isAlive() -> " + workerThread.isAlive());

        // 2. After starting the thread
        workerThread.start();
        System.out.println("After start(), isAlive() -> " + workerThread.isAlive());

        // 3. After the thread has finished
        workerThread.join(); // Wait for the thread to complete
        System.out.println("After the thread has finished, isAlive() -> " + workerThread.isAlive());
    }
}