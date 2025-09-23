import java.util.Scanner;

public class P53_P_1_n_NeonNumber {

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
        long n = sc.nextInt();

        for(int i = 1;i<n;i++)
        {
            if(isNeonNo(i))
        {
            System.out.println(i+" ");
        }
        }

      
   


    }
    public static boolean isNeonNo(long num)
    {
          long temp = num;
          long square = num*num;
          long sum = 0;

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
