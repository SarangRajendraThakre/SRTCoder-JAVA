import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class P26_UniqueDigitNumbers_Stream {

    // Check if a number has all unique digits
    public static boolean hasUniqueDigits(int n) {
        n = Math.abs(n); // handle negative numbers
        boolean[] seen = new boolean[10];
        if (n == 0) return true;

        while (n > 0) {
            int digit = n % 10;
            if (seen[digit]) return false;
            seen[digit] = true;
            n /= 10;
        }
        return true;
    }

    // Count unique-digit numbers in range using Streams
    public static long countUniqueDigitNumbersInRange(int L, int R) {
        return IntStream.rangeClosed(L, R)
                .filter(P26_UniqueDigitNumbers_Stream::hasUniqueDigits)
                .count();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of ranges: ");
        int numberOfRanges = scanner.nextInt();

        System.out.println("Enter L and R for each range:");

        for (int i = 1; i <= numberOfRanges; i++) {
            System.out.printf("Range %d (L R): ", i);
            int L = scanner.nextInt();
            int R = scanner.nextInt();

            // Swap if L > R
            if (L > R) {
                int temp = L;
                L = R;
                R = temp;
            }

            long count = countUniqueDigitNumbersInRange(L, R);
            System.out.println("Output for range [" + L + ", " + R + "]: " + count);
        }

        scanner.close();
    }
}
