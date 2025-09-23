import java.util.Scanner;

public class P61_P_1_to_n_SunnyNo {

    public static void main(String[] args) {
        // Your code here

        // Example 1: Is 8 a Sunny number?

        // Add 1 to 8: 8+1=9.

        // Check if 9 is a perfect square: 3
        // 2
        // =9. Yes, it is.

        // Conclusion: 8 is a Sunny number.

        // Example 2: Is 15 a Sunny number?

        // Add 1 to 15: 15+1=16.

        // Check if 16 is a perfect square: 4
        // 2
        // =16. Yes, it is.

        // Conclusion: 15 is a Sunny number.

        // Example 3: Is 10 a Sunny number?

        // Add 1 to 10: 10+1=11.

        // Check if 11 is a perfect square: The square root of 11 is approximately 3.31,
        // which is not an integer. Therefore, 11 is not a perfect square.

        // Conclusion: 10 is not a Sunny number.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            if (isSunnny(i)) {
                System.out.println(i);
            }

        }

    }

    public static boolean isSunnny(int num) {
        int ps = num + 1;

        for (int i = 1; i <= ps / 2; i++) {
            if (i * i == ps) {
                return true;
            }
        }
        return false;

    }
}
