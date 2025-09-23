import java.util.Scanner;

public class P68_P_EvilNO {

    // A number is called an Evil Number if the number of 1’s in its binary
    // representation is even.

    // 📌 Example:

    // 9 → Binary = 1001 → Two 1’s → Even → ✅ Evil Number

    // 15 → Binary = 1111 → Four 1’s → Even → ✅ Evil Number

    // 5 → Binary = 101 → Two 1’s → Even → ✅ Evil Number

    // 7 → Binary = 111 → Three 1’s → Odd → ❌ NOT Evil Number

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (isEvilNumber(num)) {
            System.out.println(num + " is an Evil Number.");
        } else {
            System.out.println(num + " is NOT an Evil Number.");
        }

        sc.close();
    }

    static boolean isEvilNumber(int n) {
        String binary = Integer.toBinaryString(n); // convert to binary
        int countOnes = 0;

        for (char ch : binary.toCharArray()) {
            if (ch == '1') {
                countOnes++;
            }
        }

        return countOnes % 2 == 0; // even number of 1’s
    }
}