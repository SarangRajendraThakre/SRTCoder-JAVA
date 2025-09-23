import java.util.Scanner;

public class P44_P_1_to_n_ArmstrongNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number n for finding all the Armstrong numbers up to n:");
        int num = sc.nextInt();

        // Single-digit numbers are not typically considered Armstrong numbers in this context, 
        // as the definition often applies to multi-digit numbers.
        for (int i = 1; i <= num; i++) {
            int n = countOfDigits(i);
            if (isArmstrongNo(i, n)) {
                System.out.print(i + " ");
            }
        }
    }

    // This method correctly counts the number of digits in a given number.
    public static int countOfDigits(int num) {
        if (num == 0) {
            return 1;
        }
        int count = 0;
        int temp = num;
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        return count;
    }

    // This method checks if a number is an Armstrong number.
    public static boolean isArmstrongNo(int num, int length) {
        int temp = num;
        long sum = 0; // Use a long to prevent overflow for larger numbers.
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, length); // This is the crucial part.
            temp /= 10;
        }
        return (sum == num);
    }
}