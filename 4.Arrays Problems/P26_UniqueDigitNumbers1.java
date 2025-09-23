import java.util.Scanner;

public class P26_UniqueDigitNumbers1 {

    /**
     * Checks if a number has unique digits using only an array (boolean frequency array).
     *
     * @param n The number to check.
     * @return true if all digits in the number are unique, false otherwise.
     */
    public static boolean hasUniqueDigits(int n) {
        if (n < 0) {
            n = Math.abs(n); // Handle negative numbers by taking absolute value
        }

        // A boolean array to mark the presence of digits 0-9.
        // Array size 10, index corresponds to the digit.
        boolean[] seenDigits = new boolean[10];

        if (n == 0) {
            return true; // 0 has unique digits (it's just one digit)
        }

        while (n > 0) {
            int digit = n % 10; // Get the last digit

            if (seenDigits[digit]) {
                return false; // Digit already seen
            }
            seenDigits[digit] = true; // Mark this digit as seen

            n /= 10; // Remove the last digit
        }
        return true; // All digits processed and found to be unique
    }

    /**
     * Counts the number of integers within a given range [L, R] that have no repeating digits.
     *
     * @param L The lower bound of the range (inclusive).
     * @param R The upper bound of the range (inclusive).
     * @return The count of numbers with no repeating digits in the range.
     */
    public static int countUniqueDigitNumbersInRange(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (hasUniqueDigits(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of ranges: ");
        int numberOfRanges = scanner.nextInt();

        for (int i = 0; i < numberOfRanges; i++) {
            System.out.printf("Enter range %d (L R): ", i + 1);
            int L = scanner.nextInt();
            int R = scanner.nextInt();

            if (L > R) {
                System.out.println("Warning: L should not be greater than R. Swapping values.");
                int temp = L;
                L = R;
                R = temp;
            }

            int result = countUniqueDigitNumbersInRange(L, R);
            System.out.println("Output for range [" + L + ", " + R + "]: " + result);
        }

        scanner.close();
    }
}