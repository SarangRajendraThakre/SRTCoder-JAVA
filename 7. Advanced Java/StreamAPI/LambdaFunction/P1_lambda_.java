package StreamAPI.LambdaFunction;

public class P1_lambda_ {
    public static void main(String[] args) {

        // Create object of Task class
        Task task = new Task();

        // Pass Task object to Thread
        // Thread t1 = new Thread(task);
        Thread t1 = new Thread( new Task());    

        // Start thread
        t1.start();
    }
}

// Separate class implementing Runnable
class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("hello");
    }
}
