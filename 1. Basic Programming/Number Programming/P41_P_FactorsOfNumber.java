import java.util.Scanner;

public class P41_P_FactorsOfNumber {

    public static void main(String[] args) {
        // Your code here

        // Write a program to find the factors of a number.

        System.out.println("Enter the whose factor to find");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        factorsFinding(num);

    }

    public static void factorsFinding(int num) {

        for(int  i = 1;i<=num;i++)
        {
            if(num%i==0)
            {
                System.out.print(i+" ");
            }
        }
    }
}
