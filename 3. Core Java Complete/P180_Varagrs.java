
import java.util.Arrays;

class P180_Varagrs {
    public static void main(String[] args) {
        m1();
        m1(10);
        m1(10, 20);
        m1(10, 20, 30);
        m1(10, 20, 30, 40);
        m1(10, 20, 30, 40, 50);
    }

    // Corrected method with void return type
    public static void m1(int... a) {
        // Prints the array representation of the arguments
        System.out.println(Arrays.toString(a));
    }
}
