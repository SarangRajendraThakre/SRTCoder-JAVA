import java.util.Scanner;

public class P37_P_LCMCalculator {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        // Calculate the GCD first, using the Euclidean algorithm
        int gcd = findGCD(num1, num2);

        // Use the formula to find the LCM
        long lcm = (long) num1 * num2 / gcd;

        System.out.println("The LCM of " + num1 + " and " + num2 + " is: " + lcm);

        scanner.close();
    }


    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}