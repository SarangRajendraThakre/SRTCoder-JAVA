
public class P6_P_Swapping_Without_Variable {

    public static void main(String[] args) {
        // Your code here
        // Write a program to swap two numbers without using a third variable.

        int a = 10;
        int b = 30;

        System.out.println("a : " + a);
        System.out.println("b : " + b);

        System.out.println("After Swapping");

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a :" + a);
        System.out.println("b :" + b);

    }

}
