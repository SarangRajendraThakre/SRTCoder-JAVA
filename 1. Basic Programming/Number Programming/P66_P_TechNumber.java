import java.util.Scanner;

public class P66_P_TechNumber {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (isTechNumber(num)) {
            System.out.println(num + " is a Tech Number.");
        } else {
            System.out.println(num + " is NOT a Tech Number.");
        }

        sc.close();
    }

    static boolean isTechNumber(int n) {
        int digits = String.valueOf(n).length();

        // Condition 1: number of digits must be even
        if (digits % 2 != 0) return false;

        int half = digits / 2;
        int divisor = (int) Math.pow(10, half);

        int firstHalf = n / divisor;
        int secondHalf = n % divisor;

        int sum = firstHalf + secondHalf;

        return sum * sum == n;
    }
}
