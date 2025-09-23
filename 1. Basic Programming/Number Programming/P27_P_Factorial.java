import java.util.Scanner;

public class P27_P_Factorial {

    public static void main(String[] args) {
        // Your code he
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number whose factorial you have to find :");
        int n = sc.nextInt();
        factorial(n);
    }
    public static void factorial(int num)
    {
        if(num <=0)
        {
            System.out.println("0");
        }
        if(num == 1)
        {
            System.out.println("1");
        }
        int result = 1;
        for(int i =2;i<=num;i++)
        {
            result*=i;
        }
        System.out.println(result);
    }
}
