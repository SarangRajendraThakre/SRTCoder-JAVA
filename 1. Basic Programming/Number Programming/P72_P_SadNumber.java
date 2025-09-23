
public class P72_P_SadNumber {


    // Function to check if a number is happy
    static boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            n = sumOfSquares(n);
        }
        return n == 1; // returns true if happy
    }

    // Helper function to calculate sum of squares of digits
    static int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 4;

        if (!isHappy(n)) {
            System.out.println(n + " is a Sad Number.");
        } else {
            System.out.println(n + " is a Happy Number.");
        }
    }
}
