

import java.util.Scanner;

public class P137_Throwable_Method_toString {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            // The program waits here for user input.
            // If the input is not an integer, it throws an exception.
            int a = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("catch");
            // e.toString() returns the name of the exception class.
            System.out.println(e.toString());
        }
    }
}