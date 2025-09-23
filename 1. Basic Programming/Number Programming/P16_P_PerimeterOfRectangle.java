import java.util.Scanner;

public class P16_P_PerimeterOfRectangle {

    public static void main(String[] args) {
        // Your code here

        // Write a program to calculate the perimeter of a rectangle.

        System.out.println("Enter the length and breadth of reactangle ");
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int b = sc.nextInt();
      int perimeter = 2*(l+b);
        System.out.println("Area of circle : " + perimeter);

    }
}