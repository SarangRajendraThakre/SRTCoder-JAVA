import java.util.Scanner;

public class P119_P_PascalTriangle {

  public static void main(String[] args) {
    // Your code here

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of rows for the top half: ");
    int rows = sc.nextInt();
    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1

    for (int i = 0; i < rows; i++) {
      for (int j = i; j < rows; j++) {
        System.out.print(" ");
      }
      int num = 1;

      for (int k = 0; k <= i; k++) {
        System.out.print(num + " ");
        num = num * (i - k) / (k + 1);
      }
      System.out.println();
    }

  }
}
