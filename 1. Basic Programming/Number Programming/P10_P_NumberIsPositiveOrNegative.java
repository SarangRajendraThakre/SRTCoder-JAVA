import java.util.Scanner;

public class P10_P_NumberIsPositiveOrNegative {

    public static void main(String[] args) {
        // Your code here
        // Write a program to check if a number is positive or negative.

        System.out.println("Enter the number ");
        Scanner sc = new Scanner( System.in);
        int n = sc.nextInt();
        if(n < 0)
        {
            System.out.println("Number is negative");
        }
        else
        {
            System.out.println("Number is positive");
        }
    }
}
