import java.util.Scanner;

public class P51_P_DeficientNumber {

    public static void main(String[] args) {
        // Your code here

        // What is an Abundant Number?

        // A number is called Abundant if the sum of its proper divisors (excluding
        // itself) is greater than the number.

        // ✅ Example: 12

        // Divisors of 12 (excluding 12): 1, 2, 3, 4, 6

        // Sum = 1 + 2 + 3 + 4 + 6 = 16

        // Since 16 > 12, → 12 is an Abundant Number.

        // ❌ Example: 15

        // Divisors of 15: 1, 3, 5

        // Sum = 9

        // Since 9 < 15, → 15 is NOT Abundant.but deficient Number

          Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();

        if(isAbundantNo(n))
        {
            System.out.println("The number is AbundantNo");
        }
        else
        {
            System.out.println("The number is DeficientNO");
        }


    }
    public static boolean isAbundantNo(int n)
    {
        int sum = 0;
        int temp = n;
        for(int i =1;i<n;i++)
        {
            if(n%i==0)
            {
                sum+=i;
            }
        }
        if(sum>temp)
        {
            return true;
        }
        return false;

    }
}
