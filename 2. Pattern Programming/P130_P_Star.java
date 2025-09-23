import java.util.Scanner;

public class P130_P_Star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for pattern to generate : ");
        int row = sc.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                // Conditions for star placement
                if (i == j || i + j == row - 1 || i == row / 2 || j == row / 2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
