import java.util.Scanner;

public class P35_P_GCD_bruteforce {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        int result = findGCD(num1, num2);
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + result);

        scanner.close();
    }

    public static int findGCD(int a, int b) {
        int gcd = 1;
        int min = Math.min(a, b);

        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break; // Exit the loop once the first common divisor is found
            }
        }
        return gcd;
    }
}