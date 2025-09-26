package StreamAPI;
import java.util.*;
import java.util.function.*;

public class P5_StreamFunctionalDemo {

    public static void main(String[] args) {

        // Supplier: generate a list of numbers
        Supplier<List<Integer>> numberSupplier = () -> Arrays.asList(3, 4, 7, 12, 22);

        // Function: square each number
        Function<Integer, Integer> square = n -> n * n;

        // Predicate: filter numbers greater than 10
        Predicate<Integer> greaterThan10 = n -> n > 10;

        // Consumer: print the final result
        Consumer<Integer> printNumber = n -> System.out.println("Final number: " + n);

        System.out.println("---- Stream combining Supplier, Function, Predicate, Consumer ----");

        numberSupplier.get()                           // get the list from Supplier
                      .stream()
                      .map(square)                     // Function: square each number
                      .filter(greaterThan10)           // Predicate: filter >10
                      .forEach(printNumber);           // Consumer: print each number


    }
}
