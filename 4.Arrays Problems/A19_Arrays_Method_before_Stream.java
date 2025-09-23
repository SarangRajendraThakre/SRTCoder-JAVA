public class A19_Arrays_Method_before_Stream {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6 };
        int sum = 0;
        for (int n : numbers) {
            if (n % 2 == 0) { // Filter for even numbers
                int square = n * n; // Map to its square
                sum += square; // Add to sum
            }
        }
        System.out.println("Sum using for-loop: " + sum); // Output: 56
    }
}