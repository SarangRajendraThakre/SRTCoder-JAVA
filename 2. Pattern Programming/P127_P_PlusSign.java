import java.util.Scanner;

public class P127_P_PlusSign {

    public static void main(String[] args) {
        // Your code 
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for pattern to generate : ");
        int row = sc.nextInt();


        for(int i = 0 ;i<row;i++)
        {
            for(int j = 0;j<row;j++)
            {
                  if(j==row/2 || i == row/2)
                  {
                    System.out.print("*");
                  }
                  else
                  {
                    System.out.print(" ");
                  }
            }
            System.out.println();
        }

    }
}
