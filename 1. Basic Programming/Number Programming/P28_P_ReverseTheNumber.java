import java.util.Scanner;

public class P28_P_ReverseTheNumber {

    public static void main(String[] args) {
        // Your code here

        System.out.println("Enter the number for checking of palidrome");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        reverse(num);

        String reversedStr = new StringBuilder(String.valueOf(num))
                .reverse()
                .toString();

        int reversedInt = Integer.parseInt(reversedStr);

        System.out.println("Reversed number as integer: " + reversedInt);

    }

    public static void reverse(int num) {

        int num2 = num;
        int reversed = 0;
        while (num > 0) {

            reversed = (reversed * 10) + num % 10;
            num /= 10;
        }

        System.out.println("reversed  number : " + reversed);

    }

}
