import java.util.Scanner;

public class P67_P_TrimorphicNumber {

    // What is a Trimorphic Number?

    // A Trimorphic number is a number whose cube ends with the same digits as the
    // number itself.

    // ✅ Examples:

    // 4 → 4³ = 64 → ends with 4 ✅

    // 24 → 24³ = 13824 → ends with 24 ✅

    // 249 → 249³ = 15438249 → ends with 249 ✅

    // So 4, 24, and 249 are Trimorphic numbers.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (isTrimorphic(num)) {
            System.out.println(num + " is a Trimorphic Number.");
        } else {
            System.out.println(num + " is NOT a Trimorphic Number.");
        }

        sc.close();
    }

    static boolean isTrimorphic(int n) {
        int digits = String.valueOf(n).length();
        long cube = (long) n * n * n;

        long lastDigits = cube % (long) Math.pow(10, digits);

        return lastDigits == n;
    }
}
