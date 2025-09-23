import java.util.Scanner;

public class P17_P_AreaOfTriangle {

    public static void main(String[] args) {
        // Your code here

        // Write a program to calculate the area of a triangle.

        System.out.println("Enter the length and breadth of reactangle ");
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int b = sc.nextInt();
        double perimeter = 0.5 * (l * b);
        System.out.println("Area of circle : " + perimeter);

    }

}
