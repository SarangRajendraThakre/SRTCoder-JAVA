
import java.util.Scanner;

// 1. Define the custom exception.
class UserArithmeticException extends RuntimeException {
    UserArithmeticException(String desc) {
        super(desc);
    }
}

public class P151_CustomException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Number 1: ");
        int num1 = sc.nextInt();
        
        System.out.println("Number 2: ");
        int num2 = sc.nextInt();
        
        System.out.println("Enter operator: ");
        char ch = sc.next().charAt(0);

        if (ch != '/') {
            System.out.println("Other than divide operation will be performed.");
        } else {
            // This block handles the division logic.
            if (num2 == 0) {
                // 2. Throw the custom exception if the condition is met.
                throw new UserArithmeticException("number is zero cannot be divided");
            } else {
                System.out.println(num1 / num2);
            }
        }
    }
}