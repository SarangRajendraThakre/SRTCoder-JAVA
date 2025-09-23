import java.util.Arrays;

public class P121_StoringPrimeElements {

    public static void main(String[] args) {

        int[] primeNumbers = new int[100];

        int numberToCheck = 2;
        int primeIndex = 0;

        while (primeIndex < primeNumbers.length) {

            if (isPrime(numberToCheck)) {
                primeNumbers[primeIndex] = numberToCheck;
                primeIndex++;
            }

            numberToCheck++;
        }

        System.out.println(Arrays.toString(primeNumbers));
    }

    /**
     * An efficient method to check if a number is prime.
     */
    public static boolean isPrime(int no) {

        if (no <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(no); i++) {

            if (no % i == 0) {
                return false;
            }
        }

        return true;
    }
}