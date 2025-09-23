import java.util.Scanner;

public class P15_P_areaOfCircle {

    public static void main(String[] args) {
        // Your code here
        // Write a program to calculate the area of a circle.

        System.out.println("Enter the radius");
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int area = 22/7 *r*r;
        System.out.println("Area of circle : " + area);

    }
}
