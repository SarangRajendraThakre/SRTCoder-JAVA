import java.util.Scanner;
import java.util.stream.Stream;

public class P33_P_FibonnaciNumber {

    public static void main(String[] args) {
        // Your code here

        // Write a program to print Fibonacci series up to n terms.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for fibonnaci");
        int num = sc.nextInt();

        fibonacci(num);

        // Using Stream.iterate
        Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })
                .limit(num)
                .map(t -> t[0])
                .forEach(System.out::println);

    }

    public static void fibonacci(int num) {
        int a = 0, b = 1;
        for (int i = 1; i <= num; i++) {
            System.out.print(a+" ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}