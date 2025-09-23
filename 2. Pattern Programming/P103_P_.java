import java.util.Scanner;

public class P103_P_ {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows = sc.nextInt();
        
    //     for (int i = 1; i <= rows; i++) {  // Loop for each row
    //         // Print spaces
    //         for (int j = i; j < rows; j++) {
    //             System.out.print(" ");
    //         }
    //         // Print increasing numbers
    //         for (int k = 1; k <= i; k++) {
    //             System.out.print(k + " ");
    //         }
    //         System.out.println();
    //     }
    // }

//     1 
//    1 2 
//   1 2 3 
//  1 2 3 4 
// 1 2 3 4 5

    for(int i = 1;i<=rows;i++ )
    {
        for(int j=i;j<rows;j++)
        {
            System.out.print(" ");
        }
        for(int k=1;k<=i;k++)
        {
            System.out.print(k+" ");
        }
        System.out.println();
    }

}

}