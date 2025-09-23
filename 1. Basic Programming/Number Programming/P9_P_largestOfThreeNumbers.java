
public class P9_P_largestOfThreeNumbers {

    public static void main(String[] args) {
        // Your code here

        // Write a program to find the largest of three numbers.

        int a = 10;
        int b = 43 ;
        int c = 654;

        if(a > b && a > c)
        {
            System.out.println(a +" is greater then b and c ");
        }
        else if ( b > a && b > c)
        {
            System.out.println(b + " is greater then a and c");
        }
        else
        {
            System.out.println(c + " is greater then a and b");
        }

    }
}
