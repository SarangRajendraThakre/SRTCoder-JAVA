import java.util.Scanner;

public class P36_P_GCD_Euclidian {

  // Your code here

  // Write a program to find the greatest common divisor (GCD).

  // Find the GCD of 48 and 18

  // 48÷18=2 with a remainder of 12

  // 18÷12=1 with a remainder of 6

  // 12÷6=2 with a remainder of 0

  // The last non-zero remainder is 6, so the GCD of 48 and 18 is 6.

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the first number: ");
    int num1 = scanner.nextInt();

    System.out.print("Enter the second number: ");
    int num2 = scanner.nextInt();

    int result = findGCD(num1, num2);
    System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + result);

    scanner.close();
  }

  public static int findGCD(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
