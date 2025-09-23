import java.util.Scanner;

public class P13_P_CelsiusToFahrenheit {

    public static void main(String[] args) {
        // Your code here
        // Write a program to convert Celsius to Fahrenheit.
        // C*9/5 + 32  = 32F;

        System.out.println("Enter the temperature in Celsius");
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int F = (C*9/5)+32;
        System.out.println("Fahrenheit : "+F);




    }
}
