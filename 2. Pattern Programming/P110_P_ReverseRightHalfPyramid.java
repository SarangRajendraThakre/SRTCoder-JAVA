import java.util.Scanner;

public class P110_P_ReverseRightHalfPyramid {

    public static void main(String[] args) {
        // Your code here

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows for the top half: ");
        int rows = sc.nextInt();

        for (int i = rows; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
