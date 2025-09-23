

class MyThread extends Thread {
    public void run() {
        try {
            // This thread will sleep until it is interrupted.
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            // The interruption from main() is caught here.
            System.out.println("InterruptedException handled");
        }
        
        // This loop runs after the exception is handled.
        for (int i = 1; i <= 10; i++) {
            System.out.println("Ramesh" + i);
        }
    }
}

public class P113_Try_Catch {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // Starts the MyThread instance.

        for (int i = 1; i <= 10; i++) {
            System.out.println("Main" + i);
            if (i == 9) {
                // When i is 9, the main thread interrupts t1.
                t1.interrupt();
            }
        }
    }
}