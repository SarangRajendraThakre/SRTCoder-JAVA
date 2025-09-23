import java.util.Scanner;

public class P131_HollowRightHalfPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows = sc.nextInt();

        for (int i = 0; i < rows; i++) {         // outer loop
            for (int j = 0; j <= i; j++) {       // inner loop
                // Print star at first column, last column, or last row
                if (j == 0 || j == i || i == rows - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");       // hollow space
                }
            }
            System.out.println();
        }
    }
}
