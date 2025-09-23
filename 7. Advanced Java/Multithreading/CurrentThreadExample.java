public class CurrentThreadExample {
    public static void main(String[] args) {

        // Get the main thread
        Thread mainThread = Thread.currentThread();
        System.out.println("Executing in thread: " + mainThread.getName());

        // Create a new worker thread
        Thread workerThread = new Thread(() -> {
            // Get the worker thread
            Thread currentWorkerThread = Thread.currentThread();
            System.out.println("Executing in thread: " + currentWorkerThread.getName());
            System.out.println("Is the worker the same as the main thread? " + currentWorkerThread.equals(mainThread));
        }, "My-Worker");

        workerThread.start();
    }
}