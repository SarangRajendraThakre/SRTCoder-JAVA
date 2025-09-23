import java.util.Scanner;

public class P113_P_Pyramid {

    public static void main(String[] args) {
        // Your code here

            Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows for the top half: ");
        int rows = sc.nextInt();


        for(int i = 0 ;i<rows;i++)
        {
            for(int j = i;j<rows-1;j++)
            {
                System.out.print(" ");
            }
            for(int k = 0;k<=i;k++)
            {
                System.out.print("* ");
            }
            System.out.println();

        }


    }
}
