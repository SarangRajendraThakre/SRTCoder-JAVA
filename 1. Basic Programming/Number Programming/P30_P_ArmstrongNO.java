import java.util.Scanner;

public class P30_P_ArmstrongNO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for checking Armstrong number:");
        int num = sc.nextInt();

        int n = countOfDigits(num);
        isArmstrongNo(num, n);
    }

    public static int countOfDigits(int num) {
        int count = 0;
        int temp = num;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    public static int power(int digit, int length) {
        int result = 1;
        for (int i = 1; i <= length; i++) {
            result *= digit;
        }
        return result;
    }

    public static void isArmstrongNo(int num, int length) {
        int temp = num;
        int sum = 0;
        while (temp > 0) {
          
            sum += power(temp % 10, length);
            temp /= 10;
        }
        if (sum == num) {
            System.out.println(num + " is an Armstrong number.");
        } else {
            System.out.println(num + " is NOT an Armstrong number.");
        }
    }
}
