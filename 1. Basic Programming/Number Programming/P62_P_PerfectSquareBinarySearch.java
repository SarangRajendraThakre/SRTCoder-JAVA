import java.util.Scanner;

public class P62_P_PerfectSquareBinarySearch {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (isPerfectSquare(num)) {
            System.out.println(num + " is a Perfect Square.");
        } else {
            System.out.println(num + " is NOT a Perfect Square.");
        }

        sc.close();
    }

    static boolean isPerfectSquare(int n) {
        if (n < 0) return false;
        if (n == 0 || n == 1) return true;

        int low = 1, high = n / 2;

        while (low <= high) {
            long mid = low + (high - low) / 2; // avoid overflow
            long sq = mid * mid;

            if (sq == n) return true;
            else if (sq < n) low = (int) (mid + 1);
            else high = (int) (mid - 1);
        }

        return false;
    }
}
