import java.util.Scanner;

public class P123_P_HollowReverseTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows = sc.nextInt();


        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<i;j++)
            {
                System.out.print(" ");
            }
            for(int k = i;k<rows;k++)
            {
                 if( i==0 || k==i || k==rows-1)
                 {
                     System.out.print("* ");
                 }
                 else
                 {
                    System.out.print("  ");
                 }
            }
            System.out.println();
        }

      
    }
}
