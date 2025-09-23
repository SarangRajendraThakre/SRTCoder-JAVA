import java.util.Scanner;

public class P55_P_spyNo {

  public static void main(String[] args) {
    // Your code here

    // spyNo
    // Sum of digits: 1+1+2+4=8

    // Product of digits: 1×1×2×4=8

    // Since the sum (8) is equal to the product (8), 1124 is a spy number.

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number");
    int n = sc.nextInt();

    for(int i = 1;i<=n;i++)
    {
         if (isSpyNo(i)) {
      System.out.println(i+" ");
    } 
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
