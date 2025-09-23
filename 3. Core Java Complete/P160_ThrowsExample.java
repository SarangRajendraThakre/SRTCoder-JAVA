

public class P160_ThrowsExample {

    public static void main(String[] args) {
        System.out.println("main");
        try {
            // 3. m1 is called, which will eventually throw an exception.
            m1(10, 0);
        } catch (ArithmeticException ae) {
            // 4. The exception is finally caught here.
            System.out.println("ArithmeticException handled");
        }
    }

    // This method declares it can throw the exception.
    public static void m1(int num1, int num2) throws ArithmeticException {
        System.out.println("m1()");
        // 2. div is called.
        div(num1, num2);
    }

    // This method also declares it can throw the exception.
    public static void div(int num1, int num2) throws ArithmeticException {
        System.out.println("div");
        // 1. The exception originates here.
        System.out.println(num1 / num2);
    }
}