import java.util.Arrays;

public class A21_Arrays_Method_setAll_after {
    public static void main(String[] args) {
        int[] squares = new int[5];

        // Use a lambda expression as the generator function.
        // The 'i' represents the index of the element.
        Arrays.setAll(squares, i -> i * i);

        System.out.println("Initialized array of squares: " + Arrays.toString(squares));
    }
}