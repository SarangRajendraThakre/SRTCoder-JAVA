

public class P111_Try_Catch {
    public static void main(String[] args) {
        System.out.println("Hiiii");
        try {
            System.out.println("outer try");
            try {
                System.out.println("inner try");
                // 1. First exception is thrown here
                System.out.println(10 / 0);
            } catch (ArithmeticException ae) {
                System.out.println("inner catch");
                String a = null;
                // 2. Second, new exception is thrown here
                System.out.println(a.isEmpty()); 
            }
        } catch (NullPointerException npe) {
            // 3. The second exception is caught by the outer catch block
            System.out.println("outer catch");
        }
        System.out.println("bye");
    }
}