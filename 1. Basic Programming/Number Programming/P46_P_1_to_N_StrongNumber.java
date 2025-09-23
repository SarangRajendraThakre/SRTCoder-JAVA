import java.util.Scanner;

public class P46_P_1_to_N_StrongNumber {

    public static void main(String[] args) {
        // Your code here
        //
        // Strong (Krishnamurthy) number

        // A Strong (or Krishnamurthy) number is a positive integer that is equal to the
        // sum of the factorials of its digits.

        // Step 1: Take a positive integer, let's say 145.

        // Step 2: Find the factorial of each digit. The factorial of a non-negative
        // integer n is the product of all positive integers less than or equal to n. It
        // is denoted by n!.

        // 1! = 1

        // 4! = 4 × 3 × 2 × 1 = 24

        // 5! = 5 × 4 × 3 × 2 × 1 = 120

        // Step 3: Sum the factorials of the digits.

        // 1! + 4! + 5! = 1 + 24 + 120 = 145

      Scanner sc = new Scanner( System.in);
      System.out.println("Enter the number n for range of Strong Number  like 145 : ");
      int num  = sc.nextInt();

      for(int i = 0;i<=num;i++)
      {
        if(isStrongNumber(i))
        {
          System.out.print(i+" ");
        }
      }

     




    }
    public static boolean isStrongNumber(int num)
    {
        int temp = num;
        int sum = 0;
        while (num>0) {
           sum +=  factorial(num%10);
           num/=10;
        }
        return temp==sum;
    }
    public static int factorial(int num)
    {
        int result = 1;
        for(int i =1;i<=num;i++)
        {
            result *=i;
        }
        return result;
    }
  


}
