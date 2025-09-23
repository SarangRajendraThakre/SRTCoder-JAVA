import java.util.Scanner;

public class P33_P_FibonnaciNumber {

    public static void main(String[] args) {
        // Your code here

        // Write a program to print Fibonacci series up to n terms.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for fibonnaci");
        int num = sc.nextInt();

        fibonacci(num);

    }


public static void fibonacci(int num) {
    int a = 0, b = 1;
    for (int i = 1; i <= num; i++) {
        System.out.println(a);
        int next = a + b;
        a = b;
        b = next;
    }
}
}