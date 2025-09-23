import java.util.Scanner;

public class P43_P_ArmstrongNumber{ 

    public static void main(String[] args) {
        // Your code here
        //  Armstrong number

// Write a program to check if a number is an Armstrong number.


    //    153 = 1^3 + 5^3 + 3^3 
    //    1634 = 1^4 + 6^4 + 3^4 + 4^4

       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the number for checking or Armstrong number");
       int num = sc.nextInt();

       int n = countOfDigits(num);
       isArmstrongNo(num , n);
    }
    public static int countOfDigits(int num)
    {
        int count =  0;
        while (num >0) {
            if(num/10 > 0)
            {
                count++;
            }
        }
        return count;
    }
    public static void isArmstrongNo(int num , int length)
    {
        int temp = num;
        int sum  = 0 ;
        while (num > 0) {
            sum+=num%10;
            num/=10;
        }
        if(temp == sum)
        {
            System.out.println("The number is ArmstrongNo");
        }
        else{
            System.out.println("The number is not ArmstorngNO");
        }
    }
}
