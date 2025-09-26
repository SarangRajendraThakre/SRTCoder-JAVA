package StreamAPI.LambdaFunction;

public class P2_lambda_ {
    public static void main(String[] args) {

        // Pass Task object to Thread
        // Thread t1 = new Thread(()-> {
        // System.out.println("hello");
        // });

        // lambda expression is anonymous function
        // (without access modifier ,without return type,without method name )

        Thread t1 = new Thread(() -> System.out.println("hello"));

        // Start thread
        t1.start();
    }
}
