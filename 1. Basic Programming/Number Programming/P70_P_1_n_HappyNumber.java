import java.util.HashSet;
import java.util.Scanner;

public class P70_P_1_n_HappyNumber {

    // What is a Happy Number?

    // A number is called a Happy Number if, by repeatedly replacing the number with
    // the sum of the squares of its digits, we eventually reach 1.

    // 👉 If it never reaches 1 (falls into a loop), then it’s not a Happy Number.

    // ✅ Examples:

    // 19 →
    // 1² + 9² = 82
    // 8² + 2² = 68
    // 6² + 8² = 100
    // 1² + 0² + 0² = 1 → ✅ Happy Number

    // 20 →
    // 2² + 0² = 4
    // 4² = 16
    // 1² + 6² = 37
    // 3² + 7² = 58
    // 5² + 8² = 89
    // 8² + 9² = 145
    // 1² + 4² + 5² = 42
    // 4² + 2² = 20 → loop → ❌ Not Happy Number

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        for (int i = 1; i < num; i++) {
            if (isHappyNumber(i)) {
                System.out.print(i+" ");

            } 

        }

        sc.close();
    }

    static boolean isHappyNumber(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }

        return n == 1;
    }

    static int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
