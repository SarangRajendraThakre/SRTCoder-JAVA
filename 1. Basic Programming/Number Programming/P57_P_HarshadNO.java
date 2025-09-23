import java.util.Scanner;

public class P57_P_HarshadNO {

    public static void main(String[] args) {
        // Your code here

        // A Harshad number (also known as a Niven number) is a positive integer that is
        // divisible by the sum of its digits. The term "Harshad" comes from Sanskrit
        // and means "joy-giver."

        // How to Check for a Harshad Number 🧐
        // To check if a number is a Harshad number, you must follow these two steps:

        // Calculate the sum of its digits. For a number like 18, the sum is 1+8=9.

        // Divide the original number by the sum of its digits. If the division results
        // in no remainder (i.e., the original number is perfectly divisible), it is a
        // Harshad number

            Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number");
    int n = sc.nextInt();


     if(isHarshadNo(n))
     {
        System.out.println("The number is harshad no");
     }
     else
     {
        System.out.println("The number is not a harshad no");
     }


    }
    public static boolean isHarshadNo(int num)
    {
        int temp = num;
         int sum = 0 ;
         while (num>0) {
             sum+= num%10;
             num/=10;
         }
         if(temp % sum == 0 )
         {
            return true;
         }
        else
         {
            return false;
         }
        
    }
}
