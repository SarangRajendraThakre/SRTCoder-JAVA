
public class P138_Throwable_Method_printStackTrace {

    public static void main(String[] args) {
        // 3. The call chain starts here.
        m1();
    }

    public static void m1() {
        // 2. m1 calls m2.
        m2();
    }

    public static void m2() {
        try {
            // 1. The error occurs here.
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            // printStackTrace() prints the full history of the error.
            e.printStackTrace();
        }
    }
}
