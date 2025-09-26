package Recursion;

public class FibonacciRecursion {

    public static void main(String[] args) {
        int n = 10;
        System.out.println("The " + n + "th Fibonacci number is: " + fib(n));

        System.out.println("\nFibonacci sequence up to the " + n + "th term:");
        for (int i = 0; i <= n; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
    }

    public static int fib(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
}