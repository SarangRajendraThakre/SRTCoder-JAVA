
public class P120_FinallyExample3 {
    public static void main(String[] args) {
      
        try {
            System.out.println("try");
            System.out.println("10/0");
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException handled");
            System.exit(0);
        } finally {
            System.out.println("finally block");
        }
    }
}