import java.util.Scanner;

public class P106_P_DiamondPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows for the top half: ");
        int rows = sc.nextInt();

        // Upper half of diamond (pyramid)
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) {  // spaces
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {  // stars
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half of diamond (inverted pyramid)
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = rows; j > i; j--) {  // spaces
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {  // stars
                System.out.print("*");
            }
            System.out.println();
        }
    }
}