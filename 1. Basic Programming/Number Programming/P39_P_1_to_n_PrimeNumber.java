import java.util.Scanner;

public class P39_P_1_to_n_PrimeNumber {

    public static void main(String[] args) {
        // Your code here
        // Write a program to print all prime numbers between 1 and 100.
// 

System.out.println("Enter the n");
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          for(int i = 1 ;i<=n;i++)
          {
              if(isPrime(i))
              {
                System.out.println(i);
              }
            

          }

      


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
