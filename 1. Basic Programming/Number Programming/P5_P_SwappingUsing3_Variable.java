
public class P5_P_SwappingUsing3_Variable {

    public static void main(String[] args) {
        // Your code here
        // Write a program to swap two numbers using a third variable.
        int a = 10;
        int b = 30;

        System.out.println("a : "+a);
        System.out.println("b : "+b);

        System.out.println("After Swapping");

        int c = a+b;
         a = c-a;
         b = c-a;
         System.out.println("a :"+a);
         System.out.println("b :"+b);



    }
}
