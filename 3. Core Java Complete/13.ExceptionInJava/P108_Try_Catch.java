
public class P108_Try_Catch {
    public static void main(String[] args) {
        System.out.println("Hiiii");
        try {
            System.out.println("try");
            // 1. This throws the first exception
            System.out.println(10 / 0);
        } catch (ArithmeticException ae) {
            System.out.println("catch 1");
            // 2. This throws a NEW, UNHANDLED exception, causing a crash.
            System.out.println(10 / 0); // line 14
        } catch (Exception e) {
            // 3. The second exception is caught here
            System.out.println("catch 2");
        }
        System.out.println("bye");
    }
}