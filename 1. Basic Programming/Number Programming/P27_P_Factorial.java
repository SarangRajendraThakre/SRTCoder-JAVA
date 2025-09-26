import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P27_P_Factorial {

    public static void main(String[] args) {
        // Your code he

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number whose factorial you have to find :");
        int n = sc.nextInt();
        factorial(n);
        System.out.println(factorial1(n));


        






    }

    public static void factorial(int num) {
        if (num <= 0) {
            System.out.println("0");
        }
        if (num == 1) {
            System.out.println("1");
        }
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        System.out.println(result);
    }


        // Using IntStream
    public static long factorial1(int num) {
        if (num < 0) throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        return IntStream.rangeClosed(1, num) // 1,2,3,...num
                        .reduce(1, (a, b) -> a * b); // multiply everything
    }



    public static long factorial2(int num) {
    return Stream.iterate(1, i -> i + 1) // 1,2,3,...
                 .limit(num)             // only up to num
                 .reduce(1, (a, b) -> a * b);
}






}
