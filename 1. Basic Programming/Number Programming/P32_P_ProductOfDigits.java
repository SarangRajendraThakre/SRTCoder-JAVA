import java.util.Scanner;

public class P32_P_ProductOfDigits {

    public static void main(String[] args) {
        // Your code here

        // Write a program to find the product of digits of a number.

        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for Product");
        int num = sc.nextInt();

        
     System.out.println(product(num));


    }
    public static int product(int num)
    {
        if(num ==0)
        {
            return 0;
        }
        if(num ==1){
            return 1;
        }
        int product = 1;
        while (num >0) {
            product*=num%10;
            num/=10;
        }
        return product;


    }
}
