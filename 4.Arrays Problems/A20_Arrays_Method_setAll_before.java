

import java.util.Arrays;
import java.util.Spliterator;
import java.util.List;
import java.util.ArrayList;

public class A20_Arrays_Method_setAll_before {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Grape", "Kiwi", "Mango"));

        // 1. Get a Spliterator for the entire list

  // When you call .parallel(), Java uses the spliterator() behind the scenes to break the work up for concurrent execution.
        Spliterator<String> spliterator1 = fruits.spliterator();

        // 2. Split it. spliterator2 gets a portion, and spliterator1's size is reduced.
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        System.out.println("--- Processing first half ---");
        // spliterator1 now covers the first half of the data
        if (spliterator1 != null) {
            spliterator1.forEachRemaining(System.out::println);
        }

        System.out.println("\n--- Processing second half ---");
        // spliterator2 covers the second half
        if (spliterator2 != null) {
            spliterator2.forEachRemaining(System.out::println);
        }
    }
}