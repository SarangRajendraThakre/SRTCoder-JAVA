import java.util.Scanner;

public class P122_P_HollowTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows = sc.nextInt();

        for (int i = 0; i < rows; i++) {
            // spaces
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }

            // stars and hollow spaces
            for (int k = 0; k <= i; k++) {
                if (k == 0 || k == i || i == rows - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  "); // double space for alignment
                }
            }
            System.out.println();
        }
    }
}
