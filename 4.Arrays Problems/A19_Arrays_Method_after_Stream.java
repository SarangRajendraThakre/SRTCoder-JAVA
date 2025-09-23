
import java.util.Arrays;

public class A19_Arrays_Method_after_Stream {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};

        // 1. Get a stream from the array
        int sum = Arrays.stream(numbers)
        // 2. Chain operations
                        .filter(n -> n % 2 == 0) // Intermediate: keeps only even numbers [2, 4, 6]
                        .map(n -> n * n)         // Intermediate: squares each number [4, 16, 36]
                        .sum();                  // Terminal: calculates the final sum

        System.out.println("Sum using stream: " + sum); // Output: 56
    }
}