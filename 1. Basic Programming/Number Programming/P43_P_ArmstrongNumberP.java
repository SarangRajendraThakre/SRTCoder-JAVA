import java.util.Scanner;

public class P43_P_ArmstrongNumberP {

    public static void main(String[] args) {
        // Your code here
        // Armstrong number

        // Write a program to check if a number is an Armstrong number.

        // 153 = 1^3 + 5^3 + 3^3
        // 1634 = 1^4 + 6^4 + 3^4 + 4^4

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for checking or Armstrong number");
        int num = sc.nextInt();

        int n = String.valueOf(num).length();

        if (isArmstrongNo(num, n)) {

            System.out.println("The number is armstorng number");
        } else {
            System.out.println("The numbe ris not armstrong number");

        }

    }

    public static boolean isArmstrongNo(int num, int power) {
        int temp = num;
        int sum = 0;

        while (num > 0) {

            sum += Math.pow(num % 10, power);
            num /= 10;

        }
        if (temp == sum) {
            return true;
        } else {
            return false;
        }

    }

}