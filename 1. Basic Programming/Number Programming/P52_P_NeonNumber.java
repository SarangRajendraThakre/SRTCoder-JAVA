import java.util.Scanner;

public class P52_P_NeonNumber {

    public static void main(String[] args) {
        // Your code here

        // example, let's take the number 9:

        // Step 1: Square the number: 9
        // 2
        // =81.

        // Step 2: Sum the digits of the square: 8+1=9.

        // Step 3: Compare the sum (9) with the original number (9). Since they are
        // equal, 9 is a Neon number.


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

        if(isNeonNo(n))
        {
            System.out.println("The number is neon number");
        }
        else
        {
            System.out.println("The number is not neon number");
        }


    }
    public static boolean isNeonNo(int num)
    {
          int temp = num;
          int square = num*num;
          int sum = 0;

          while (square>0) {
            sum+=square%10 ;
            square/=10;
          }

          if(temp==sum)
          {
            return true;
          }
          else
          {
            return false;
          }


    }
}
