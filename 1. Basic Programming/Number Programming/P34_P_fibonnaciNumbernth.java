import java.util.Scanner;

public class P34_P_fibonnaciNumbernth {

    public static void main(String[] args) {
        // Your code here

        // Write a program to find the nth Fibonacci number.

        // 1 1 2 3 5 8 13

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the nth term ");
        int num = sc.nextInt();
        fibonnaci(num);


    }
    public static void fibonnaci(int num)
    {
        int count=2;
        int a =1;
        int b = 1;
        while (++count <= num) {
            b = a+b;
            a=  b-a;
        }
        System.out.println("The nth fibonnaci number is : "+b);
    }
}
