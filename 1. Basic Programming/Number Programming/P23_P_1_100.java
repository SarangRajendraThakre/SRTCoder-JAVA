import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P23_P_1_100 {

    public static void main(String[] args) {
        // Your code here
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }

   // Supplier that generates numbers starting from 1
        Supplier<Integer> numberSupplier = new Supplier<>() {
            private int n = 1;

            @Override
            public Integer get() {
                return n++;
            }
        };

        // Use Stream.generate() with limit(100) to print 1 to 100
        Stream.generate(numberSupplier)
              .limit(100)   // only take first 100 numbers
              .forEach(System.out::println);
    }


    }

