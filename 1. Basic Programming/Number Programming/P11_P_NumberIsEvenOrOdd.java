import java.util.Scanner;

public class P11_P_NumberIsEvenOrOdd {

    public static void main(String[] args) {
        // Your code here

        // Write a program to check if a number is even or odd.

         System.out.println("Enter the number ");
        Scanner sc = new Scanner( System.in);
        int n = sc.nextInt();
        if(n %2 ==0)
        {
            System.out.println("Number is even");
        }
        else
        {
            System.out.println("Number is odd");
        }



    }
}
