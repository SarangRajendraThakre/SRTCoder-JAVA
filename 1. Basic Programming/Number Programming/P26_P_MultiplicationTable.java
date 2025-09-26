import java.util.Scanner;
import java.util.stream.Stream;

public class P26_P_MultiplicationTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number whose table to find out");
        int n = sc.nextInt();
        
        // Traditional way
        System.out.println("\nTraditional way---------------------");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }

        System.out.println("\nUsing Stream API:");

        // Stream way
        Stream.iterate(1, i -> i + 1) // generate 1,2,3...
                .limit(10) // only first 10
                .forEach(i -> System.out.println(n + " * " + i + " = " + (n * i)));
    }
}
