import java.util.Scanner;

public class P38_P_PrimeNo {

    public static void main(String[] args) {
        // Your code here

        // Write a program to check if a number is prime.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = sc.nextInt();

        boolean result = isPrime(num);
      
        if(result)
        {
            System.out.println("The number is prime number");
        }
        else
        {
            System.out.println("The number is not prime number");
        }



    }
    public static boolean isPrime(int num)
    {
        if(num<2)
        {
            return false;
        }
        for(int i = 2;i<num;i++)
        {
            if(num%i==0)
            {
                return false;

            }
        }
       return true;
    }
}
