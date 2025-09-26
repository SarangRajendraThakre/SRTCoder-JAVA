import java.util.Scanner;

public class P29_P_PalindromeCheck {

    public static void main(String[] args) {
        // Your code here

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you wnat to check the palindrom number or not");
        int num = sc.nextInt();
        isPalindrome(num);


        String result =  new StringBuilder(String.valueOf(num))
                  .reverse()
                  .toString();

         
         if(Integer.parseInt(result)==num){
            System.out.println("The string is palindrone");
         }
         else
         {
            System.out.println("The string is not palilndrome");
         }


    }
    public static void isPalindrome(int num)
    {
        int temp = num;
        int reversed = 0;
        while (num>0) {
            reversed = reversed*10 + num%10;
        num/=10;
        
        }
        System.out.println(temp==reversed);


        
                 
        
    }
}
