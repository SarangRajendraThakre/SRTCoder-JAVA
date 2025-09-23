import java.util.Scanner;

public class P117_P_KPattern {

    public static void main(String[] args) {
        // Your code here


            Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows for the top half: ");
        int rows = sc.nextInt();

        for(int i = rows;i>0;i--)
        {
            for(int j = 0;j<i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 0;i<rows-1;i++)
        {
            for(int j=0;j<i+2;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
