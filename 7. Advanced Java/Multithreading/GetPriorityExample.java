public class GetPriorityExample {
    public static void main(String[] args) {

        Thread myThread = new Thread(() -> {
            // This is the task for the thread
            System.out.println("Worker thread is running...");
        });

        // The default priority is usually 5
        System.out.println("Default priority: " + myThread.getPriority());

        // Now, let's suggest a new priority
        myThread.setPriority(Thread.MAX_PRIORITY);

        // Use getPriority() to confirm the change
        System.out.println("New priority: " + myThread.getPriority());

        myThread.start();
    }
}