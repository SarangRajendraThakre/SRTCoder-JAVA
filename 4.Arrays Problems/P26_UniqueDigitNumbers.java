import java.util.Scanner;

public class P26_UniqueDigitNumbers {

  
    public static boolean hasUniqueDigits(int n) {
        if (n < 0) {
            n = Math.abs(n);
        }
        if (n == 0) {
            return true;
        }
        boolean[] seenDigits = new boolean[10];
        while (n > 0) {
            int digit = n % 10;
            if (seenDigits[digit]) {
                return false;
            }
            seenDigits[digit] = true;
            n /= 10;
        }
        return true;
    }

   
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

        System.out.print("Enter the number of ranges (rows for the 2D array): ");
        int numberOfRanges = scanner.nextInt();

        int[][] rangesArray = new int[numberOfRanges][2];

        System.out.println("Now, enter the L and R values for each range:");

        for (int i = 0; i < numberOfRanges; i++) {
            System.out.printf("Enter L and R for range %d (e.g., 1 20): ", i + 1);
            rangesArray[i][0] = scanner.nextInt();
            rangesArray[i][1] = scanner.nextInt();

            if (rangesArray[i][0] > rangesArray[i][1]) {
                System.out.println("Warning: L was greater than R for range " + (i + 1) + ". Swapping values.");
                int temp = rangesArray[i][0];
                rangesArray[i][0] = rangesArray[i][1];
                rangesArray[i][1] = temp;
            }
        }

        System.out.println("\nProcessing ranges from the 2D array:");

        for (int i = 0; i < numberOfRanges; i++) {
            int L = rangesArray[i][0];
            int R = rangesArray[i][1];

            int result = countUniqueDigitNumbersInRange(L, R);
            System.out.println("Output for range [" + L + ", " + R + "]: " + result);
        }

        scanner.close();
    }
}