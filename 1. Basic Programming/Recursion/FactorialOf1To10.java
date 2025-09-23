package Recursion;

public class FactorialOf1To10 {

    public static void main(String[] args) {

        printFactorialsDescending(10);
    }

    public static long findFactorialRecursive(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * findFactorialRecursive(n - 1);
    }

    public static void printFactorialsDescending(int num) {

        if (num <= 0) {
            return;
        }

        long factorial = findFactorialRecursive(num);

        System.out.println("Factorial of " + num + ": " + factorial);

        printFactorialsDescending(num - 1);
    }
}