
public class P121_FinallyExample5 {
    public static void main(String[] args) {
        
        try {
            System.out.println("try");
            // This throws an exception.
            System.out.println(10 / 0);
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException handled");
            // This command terminates the entire program immediately.
            System.exit(0); 
        } finally {
            // This block is never reached because the JVM was shut down.
            System.out.println("finally block");
        }
    }
}