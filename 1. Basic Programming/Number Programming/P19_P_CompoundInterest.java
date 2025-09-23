import java.util.Scanner;

public class P19_P_CompoundInterest {

    public static void main(String[] args) {
        // Your code here
        // Write a program to calculate compound interest.

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the principal amoutn");
        int P = sc.nextInt();
        System.out.println("enter the rate ");
        int R = sc.nextInt();
        System.out.println("Enter the time");
        int T = sc.nextInt();
        int n = 12 ;
        int amount = P *(1+R/n)^n*T;
        System.out.println(amount);

    }
}
