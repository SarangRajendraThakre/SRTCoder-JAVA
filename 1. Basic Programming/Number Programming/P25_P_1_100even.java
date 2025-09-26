import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P25_P_1_100even {

    public static void main(String[] args) {
        // Your code here

        System.out.println("\n---------------WithOut Stream Api---------------------------");

        int n = 1;
        while (n <= 100) {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
            n++;
        }

        System.out.println("\n---------------With Stream Api---------------------------");

        IntStream.rangeClosed(1, 100) // generates 1 to 100
                .filter(m -> m % 2 == 0)
                .forEach(m -> System.out.print(m + " "));

        System.out.println();
        System.out.println(" -------------------using the Stream.iterate()------------------");
        Stream.iterate(1, nn -> nn + 1) // infinite stream: 1, 2, 3, ...
                .limit(100) // restrict to first 100
                .forEach(nn -> System.out.print(nn + " "));

    }
}
