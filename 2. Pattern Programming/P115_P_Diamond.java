import java.util.Scanner;

public class P115_P_Diamond {

    public static void main(String[] args) {
        // Your code here

                    Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows for the top half: ");
        int rows = sc.nextInt();

// upper half
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


        // lower half

        
        for (int i = 0; i < rows-1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = i; k < rows-1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }


    }
}
