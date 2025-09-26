package ExceptionInJava;
public class P166_Throws_Unchecked_Exception  {

    public static void main(String[] args) {
        // The program will crash here, but there is no compile-time error.
        divide(10, 0); 
        System.out.println(" unexpected  termination of program because we are not handling it");
    }

    // NO 'throws' keyword is required here for ArithmeticException.
    public static void divide(int a, int b) {
        System.out.println(a / b);
    }
}