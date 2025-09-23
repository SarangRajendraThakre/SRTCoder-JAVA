public class SetNameExample {
    public static void main(String[] args) {

        Runnable fileProcessingTask = () -> {
            // Get the current thread's name and print it
            String threadName = Thread.currentThread().getName();
            System.out.println("Starting task on thread: " + threadName);
            // ... do some work ...
            System.out.println("Finished task on thread: " + threadName);
        };

        // --- Method 1: Using setName() ---
        Thread thread1 = new Thread(fileProcessingTask);
        thread1.setName("FileProcessor-A"); // Set the name after creation

        // --- Method 2: Using the constructor (more common) ---
        Thread thread2 = new Thread(fileProcessingTask, "FileProcessor-B");

        thread1.start();
        thread2.start();
    }
}