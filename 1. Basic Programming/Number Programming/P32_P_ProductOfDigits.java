import java.util.Scanner;

public class P32_P_ProductOfDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for product:");
        int num = sc.nextInt();

        // Using traditional method
        System.out.println("Using loop: " + product(num));

        // Using Stream API
        int productStream = String.valueOf(num)
                .chars() // IntStream of chars
                .map(c -> Character.getNumericValue(c)) // convert char to int
                .reduce(1, (a, b) -> a * b); // multiply all digits

        System.out.println("Using Stream: " + productStream);
    }

    public static int product(int num) {
        if (num == 0)
            return 0;
        int product = 1;
        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }
        return product;
    }
}
