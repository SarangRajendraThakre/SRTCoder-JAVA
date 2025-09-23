import java.util.Scanner;

public class P114_P_ReversePyramid {

    public static void main(String[] args) {
        // Your code here

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows for the top half: ");
        int rows = sc.nextInt();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = i; k < rows; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
