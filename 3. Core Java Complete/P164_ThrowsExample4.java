

public class P164_ThrowsExample4 {
    public static void main(String[] args) {
        m1();
    }

    // It's valid to declare unchecked exceptions even if they aren't thrown.
    public static void m1() throws ArithmeticException, IndexOutOfBoundsException {
        System.out.println("m1()");
    }
}