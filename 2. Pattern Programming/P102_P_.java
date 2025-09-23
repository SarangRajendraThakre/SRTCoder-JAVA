import java.util.Scanner;

public class P102_P_ {

    public static void main(String[] args) {
        // Your code here

//     *  
//    * *  
//   * * *  
//  * * * *  
// * * * * *        

            Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows = sc.nextInt();  // Takes input from user for number of rows
        
        for (int i = 1; i <= rows; i++) {  // Outer loop controls each row
            for (int j = i; j < rows; j++) {  // Loop for spaces before stars
                System.out.print(" ");  // Prints a space
            }
            for (int k = 1; k <= (2 * i - 1); k++) {  // Loop for printing stars
                System.out.print("* ");  // Prints a star followed by a space
            }
            System.out.println();  // Moves to next line after finishing a row
        }
    }
}