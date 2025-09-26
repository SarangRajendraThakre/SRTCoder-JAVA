import java.util.Scanner;

public class P118_P_ButterflyPatternP {

    public static void main(String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows for the top half: ");
        int rows = sc.nextInt();

        // *                *         //  
        // **              **
        // ***            ***
        // ****          ****
        // *****        *****
        // ******      ******
        // ************
        // ***** *****
        // **** ****
        // *** ***
        // ** **
        // * *


        for(int i = 0 ;i<=rows;i++)
        {
            for(int j = 0 ; j<=2* rows  ;j++)
            {
                if(j>i && j<2*rows-i )
                {
                    System.out.print(" ");
                    
                }
                else
                {
                    System.out.print("*");
                }

            }
            System.out.println();

        }

        

      
    }
}
