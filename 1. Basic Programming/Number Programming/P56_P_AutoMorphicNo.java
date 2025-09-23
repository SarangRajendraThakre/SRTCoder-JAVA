import java.util.Scanner;

public class P56_P_AutoMorphicNo {

    public static void main(String[] args) {
        // Your code here
        // An Automorphic number is a number whose square ends with the same digits as
        // the number itself.

        // For example, to check if the number 25 is an Automorphic number, you'd follow
        // these steps:

        // Step 1: Square the number: 25
        // 2
        // =625.

        // Step 2: Check if the last digit(s) of the square are the same as the original
        // number. The number 625 ends in 25, which is the same as the original number.

        // Conclusion: Therefore, 25 is an Automorphic number.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

        int squre = n*n;
        if(squre%10 == n%10)
        {
            System.out.println("Automorphic Number");
        }
        else
        {
            System.out.println("Not a automorphic Number");
        }

    }
}
