public class GetNameExample {
    public static void main(String[] args) {

        Runnable task = () -> {
            // Get the name of the currently executing thread
            String currentThreadName = Thread.currentThread().getName();
            System.out.println("This task is being executed by: " + currentThreadName);
        };

        // Thread with a custom name
        Thread customNameThread = new Thread(task, "My-Worker-Thread");

        // Thread that will get a default name
        Thread defaultNameThread = new Thread(task);

        customNameThread.start();
        defaultNameThread.start();
    }
}