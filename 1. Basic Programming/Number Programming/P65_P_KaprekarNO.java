import java.util.Scanner;

public class P65_P_KaprekarNO {

    public static void main(String[] args) {
        // Your code here

        // What is a Kaprekar Number?

        // A Kaprekar number is a number whose square can be split into two parts, and
        // the sum of those parts is equal to the original number.

        // Example:

        // 45 is a Kaprekar number.

        // 45² = 2025

        // Split into 20 and 25 → 20 + 25 = 45 ✅

        // 9 is also Kaprekar:

        // 9² = 81

        // Split into 8 and 1 → 8 + 1 = 9 ✅

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

       if(isKaprekar(n))
       {
        System.out.println("The number is Kaprekar");
       }
       else
       {
        System.out.println("The number is not Kaprekar");
       }
       sc.close();

    }
    static boolean isKaprekar(int n) {
    if (n == 1) return true; // 1 is Kaprekar

    long sq = (long) n * n;
    int d = String.valueOf(n).length(); // number of digits in n

    long powTen = (long) Math.pow(10, d);
    long right = sq % powTen;
    long left = sq / powTen;

    return (left + right == n);
}

}
