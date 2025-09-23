import java.util.Scanner;

public class P118_P_ButterflyPattern {

    public static void main(String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows for the top half: ");
        int rows = sc.nextInt();

        // * *
        // ** **
        // *** ***
        // **** ****
        // ***** *****
        // ************
        // ************
        // ***** *****
        // **** ****
        // *** ***
        // ** **
        // * *

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= rows * 2; j++) {
                if (j > i && j < rows * 2 - i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();

        }

        for (int i = rows-1; i >= 0; i--) {
            for (int j = 0; j <= rows * 2; j++) {
                if (j > i && j < rows * 2 - i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

    }
}
