import java.util.Scanner;

public class P20_P_LeapYear {

    public static void main(String[] args) {
        // Your code here
        // Write a program to check if a year is a leap year.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year");
        int y = sc.nextInt();
        if (y % 4 == 0 && !(y % 100 == 0)) {
            System.out.println(y + " is Leap year");
        } else if (y % 400 == 0) {
            System.out.println(y + " is leap year");
        } else

        {
            System.out.println(y + " is not leap year");
        }

    }
}
