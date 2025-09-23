import java.util.Scanner;

public class P105_P_ {

    public static void main(String[] args) {
        // Your code here
      Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows = sc.nextInt();

        for(int i = 1;i<=rows;i++)
        {
            
            for(int j = i;j<=rows;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
