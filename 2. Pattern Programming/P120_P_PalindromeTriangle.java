import java.util.Scanner;

public class P120_P_PalindromeTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows = sc.nextInt();

        for (int i = 1; i <= rows; i++) {
            // Spaces
            for (int j = i; j < rows; j++) {
                System.out.print("  "); // double space for alignment
            }

            // Descending numbers (i to 1)
            for (int k = i; k >= 1; k--) {
                System.out.print(k + " ");
            }

            // Ascending numbers (2 to i)
            for (int k = 2; k <= i; k++) {
                System.out.print(k + " ");
            }

            System.out.println();
        }
    }
}
