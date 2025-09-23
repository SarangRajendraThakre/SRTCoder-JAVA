import java.util.Scanner;

public class P14_P_FahrenheiToCelsius {

    public static void main(String[] args) {
        // Your code here
        // Write a program to convert FahrenheiToCelsius .

        
        System.out.println("Enter the temperature in Celsius");
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int C = (F-32 ) * 5/9;
        System.out.println("Fahrenheit : "+C);


    }
}
