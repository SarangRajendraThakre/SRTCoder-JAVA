import java.util.Scanner;

public class P174_ {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(palindrome(n));

    }

    public static int  palindrome(int n)
    {
        
        int reversed = 0;
        while(n>0)
         {reversed += n%10*10;
           n/=10;
         }
         return reversed;
    }
}
