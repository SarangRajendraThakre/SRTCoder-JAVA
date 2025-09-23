

import java.util.Scanner;

// 1. Define the custom exception class.
class AgeNotEligible extends RuntimeException {
    // Constructor to set the custom error message.
    AgeNotEligible(String desc) {
        super(desc);
    }
}

public class P150_CustomException1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an age: ");
        int age = sc.nextInt();

        if (age < 18) {
            try {
                // 2. Throw the custom exception if the condition is met.
                throw new AgeNotEligible("Age is less than 18");
            } catch (AgeNotEligible ane) {
                // 3. Catch the custom exception and print its message.
                System.out.println(ane.getMessage());
            }
        } else {
            System.out.println("Eligible for driving");
        }
    }
}