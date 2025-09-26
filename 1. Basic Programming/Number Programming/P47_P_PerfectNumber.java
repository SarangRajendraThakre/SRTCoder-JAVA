import java.util.Scanner;

public class P47_P_PerfectNumber {

    public static void main(String[] args) {
        // Your code here

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();

        System.out.println(isPerfectNumber(n));

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
