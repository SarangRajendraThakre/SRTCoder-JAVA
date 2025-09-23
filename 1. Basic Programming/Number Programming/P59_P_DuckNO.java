import java.util.Scanner;

public class P59_P_DuckNO {

    public static void main(String[] args) {
        // Your code here

        // A Duck number is a positive integer that contains the digit zero, but does
        // not start with it. 🦆
        // Duck Numbers: 10, 203, 7054, 8009, 100
        // Non-Duck Numbers: 5, 123, 8976, 129, 0123

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

        if(isDuckNO(n))
        {
            System.out.println("Then number is Duck No");
        }
        else
        {
            System.out.println("Then number is not Duck No");
        }


    }
    public static boolean isDuckNO(int num)
    {
        while (num > 0) {
            
            if(num%10==0)
            {
               return true;
            }
        num/=10;
        }
        return false;

    }
}
