import java.util.Scanner;

public class SquareRootNewtonRaphson {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative number to find its square root: ");
        double num = sc.nextDouble();


        double guess = num / 2.0;
        double epsilon = 1e-9;

        while (Math.abs(guess * guess - num) > epsilon) {
            guess = 0.5 * (guess + (num / guess));
        }

        System.out.println(" square root of " + num + " is " + guess);

        sc.close();
    }
}