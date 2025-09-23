public class ThreadMethods_run_vs_start {

    public static void main(String[] args) {

        Runnable myTask = () -> {

            for (int i = 0; i < 3; i++) {
                System.out.println("Running in thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread myThread = new Thread(myTask, "MyWorkerThread");

        System.out.println("Calling start() now from thread: " + Thread.currentThread().getName());

        myThread.run(); 
         // myThread.start();



    }

}
