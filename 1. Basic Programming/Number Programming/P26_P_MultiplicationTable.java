import java.util.Scanner;

public class P26_P_MultiplicationTable{

    public static void main(String[] args) {
        // Your code here

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number whose table to find out");
        int n = sc.nextInt();

        for(int i = 1;i<=10;i++)
        {
            System.out.println(n+" * "+i+" : "+n*i);
        }
    }
}
