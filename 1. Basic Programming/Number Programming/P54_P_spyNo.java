import java.util.Scanner;

public class P54_P_spyNo {

  public static void main(String[] args) {
    // Your code here

    // spyNo
    // Sum of digits: 1+1+2+4=8

    // Product of digits: 1×1×2×4=8

    // Since the sum (8) is equal to the product (8), 1124 is a spy number.

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number");
    int n = sc.nextInt();

    if (isSpyNo(n)) {
      System.out.println("The number is spyno");
    } else {
      System.out.println("The number is not spyno");
    }

  }

  public static boolean isSpyNo(int n) {
    int sum = 0;
    int product = 1;
    int temp1 = n;
    int temp2 = n;
    while (temp1 > 0) {
      sum += temp1 % 10;
      temp1 /= 10;
    }
    while (temp2 > 0) {
      product *= temp2 % 10;
      temp2 /= 10;
    }
    if (sum == product) {
      return true;
    } else {
      return false;
    }
  }
}
