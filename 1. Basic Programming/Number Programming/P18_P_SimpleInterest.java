import java.util.Scanner;

public class P18_P_SimpleInterest {

    public static void main(String[] args) {
        // Your code here
        // Write a program to calculate simple interest.

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the principal amoutn");
        int P = sc.nextInt();
        System.out.println("enter the rate ");
        int R = sc.nextInt();
        System.out.println("Enter the time");
        int T = sc.nextInt();
        int result = P * R * T / 100;
        System.out.println(result);

    }

}
