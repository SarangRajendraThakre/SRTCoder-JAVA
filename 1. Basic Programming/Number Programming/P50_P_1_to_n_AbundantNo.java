import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P50_P_1_to_n_AbundantNo {

    public static void main(String[] args) {
        // Your code here

        // What is an Abundant Number?

        // A number is called Abundant if the sum of its proper divisors (excluding
        // itself) is greater than the number.

        // ✅ Example: 12

        // Divisors of 12 (excluding 12): 1, 2, 3, 4, 6

        // Sum = 1 + 2 + 3 + 4 + 6 = 16

        // Since 16 > 12, → 12 is an Abundant Number.

        // ❌ Example: 15

        // Divisors of 15: 1, 3, 5

        // Sum = 9

        // Since 9 < 15, → 15 is NOT Abundant.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (isAbundantNo(i)) {
                list1.add(i);
            } else {
                list2.add(i);
            }
        }
        System.out.println("The Abundant Numbers are ");

        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println("The Deficient Numbers are ");
        System.out.println(Arrays.toString(list2.toArray()));

    }

    public static boolean isAbundantNo(int n) {
        int sum = 0;
        int temp = n;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        if (sum > temp) {
            return true;
        }
        return false;

    }
}
