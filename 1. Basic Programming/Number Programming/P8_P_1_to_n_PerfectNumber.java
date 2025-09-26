import java.util.Scanner;

public class P8_P_1_to_n_PerfectNumber {

    public static void main(String[] args) {

        // Perfect Number is a proper divisor sum equals perfect number
        // Proper divisors: 1, 2, 3
        // Sum: 1 + 2 + 3 = 6 ✅ → Perfect
        // 28
        // Proper divisors: 1, 2, 4, 7, 14
        // Sum: 1 + 2 + 4 + 7 + 14 = 28 ✅ → Perfect
        // 496
        // Proper divisors sum to 496 ✅ → Perfect

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if (isPerfectNumber(i)) {
                System.out.print(i + " ");
            }
        }

    }

    public static boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            int temp = n;
            if (n % i == 0) {
                sum += i;
            }

        }
        if (sum == n) {
            return true;
        } else {
            return false;
        }
    }
}
