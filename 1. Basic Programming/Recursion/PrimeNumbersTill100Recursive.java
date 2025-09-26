package Recursion;

public class PrimeNumbersTill100Recursive {

    private static boolean isPrimeRecursive(int n, int divisor) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        if (divisor * divisor > n) {
            return true;
        }
        return isPrimeRecursive(n, ++divisor);
    }

    public static void printPrimesRecursive(int currentNumber, int limit) {

        if (currentNumber > limit) {
            return;
        }

        if (isPrimeRecursive(currentNumber, 2)) {
            System.out.print(currentNumber + " ");
        }

        printPrimesRecursive(currentNumber + 1, limit);
    }

    public static void main(String[] args) {
        System.out.println("Prime numbers up to 100:");
        printPrimesRecursive(2, 100);
        System.out.println();
    }
}