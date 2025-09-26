import java.util.Scanner;

public class P31_P_SumOfDigits {

    public static void main(String[] args) {
        // Your code here

        // Write a program to find the sum of digits of a number.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for sum");
        int num = sc.nextInt();

        // int sum = 0;
        // while (num > 0) {
        //      sum+=num%10;
        //       num/=10; 
        // }


           int sum = String.valueOf(num)          // convert number to string
                        .chars()               // IntStream of characters
                        .map(c -> Character.getNumericValue(c)) // convert char to int
                        .sum();    





        System.out.println("The sum of number is :"+sum);
        

    }
}
