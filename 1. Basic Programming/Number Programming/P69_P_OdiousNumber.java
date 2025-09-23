import java.util.Scanner;

public class P69_P_OdiousNumber {

    // 🔹 What is an Odious Number?

    // An Odious Number is the opposite of an Evil Number.
    // 👉 A number is called Odious if the number of 1’s in its binary
    // representation is odd.

    // ✅ Examples:

    // 7 → Binary = 111 → 3 ones → Odd → ✅ Odious

    // 9 → Binary = 1001 → 2 ones → Even → ❌ Not Odious

    // 5 → Binary = 101 → 2 ones → Even → ❌ Not Odious

    // 13 → Binary = 1101 → 3 ones → Odd → ✅ Odious

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (isOdiousNumber(num)) {
            System.out.println(num + " is an Odious Number.");
        } else {
            System.out.println(num + " is NOT an Odious Number.");
        }

        sc.close();
    }

    static boolean isOdiousNumber(int n) {
        String binary = Integer.toBinaryString(n); // convert to binary
        int countOnes = 0;

        for (char ch : binary.toCharArray()) {
            if (ch == '1') {
                countOnes++;
            }
        }

        return countOnes % 2 != 0; // odd number of 1’s
    }
}
