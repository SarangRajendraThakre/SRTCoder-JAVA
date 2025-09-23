import java.util.Scanner;

public class P40_P_SumOfAllPrimeNoUptoNth {


    public static void main(String[] args) {
        // Your code here
        // Write a program to print all prime numbers between 1 and 100.
// 

System.out.println("Enter the n");
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int sum = 0 ;
          for(int i = 1 ;i<=n;i++)
          {
              if(isPrime(i))
              {
                 sum +=i;
              }
            

          }
          System.out.println("The sum of all prime no is "+sum);

      


    }
    public static boolean isPrime(int num)
    {
        if(num < 2 ) return false;
        for(int i = 2;i<num;i++)
        {
            if(num%i==0) return false;
        }
        return true;
    }
}
