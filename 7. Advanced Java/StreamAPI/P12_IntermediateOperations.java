package StreamAPI;

import java.util.*;
import java.util.stream.*;

public class P12_IntermediateOperations {
        public static void main(String[] args) {

                // 1. Transforming
                // map(Function) → transform each element
                // mapToInt(ToIntFunction) / mapToLong / mapToDouble → map to primitive streams
                // flatMap(Function) → flatten nested streams
                // flatMapToInt / flatMapToLong / flatMapToDouble

                // 2. Filtering
                // filter(Predicate) → keep only matching elements
                // distinct() → remove duplicates
                // takeWhile(Predicate) (Java 9+) → take elements while condition holds
                // dropWhile(Predicate) (Java 9+) → drop elements while condition holds

                // 3. Sorting
                // sorted() → natural order
                // sorted(Comparator) → custom order

                // 4. Slicing
                // limit(long n) → keep first n elements
                // skip(long n) → skip first n elements

                // 5. Peeking
                // peek(Consumer) → debug/inspect elements (doesn’t modify)

                List<String> names = Arrays.asList("java", "python", "c", "java", "spring", "springboot", "c++",
                                "javascript");

                System.out.println("Original List: " + names);

                // 1️⃣ filter
                List<String> filtered = names.stream()
                                .filter(s -> s.length() > 3)
                                .collect(Collectors.toList());
                System.out.println("Filter (length > 3): " + filtered);

                // 2️⃣ map
                List<Integer> mapped = names.stream()
                                .map(String::length)
                                .collect(Collectors.toList());
                System.out.println("Map (String length): " + mapped);

                // 3️⃣ mapToInt
                IntStream intStream = names.stream()
                                .mapToInt(String::length);
                System.out.print("mapToInt: ");
                intStream.forEach(n -> System.out.print(n + " "));
                System.out.println();

                // 4️⃣ flatMap
                List<List<String>> nested = Arrays.asList(
                                Arrays.asList("a", "b"),
                                Arrays.asList("c", "d"));
                List<String> flatMapped = nested.stream()
                                .flatMap(List::stream)
                                .collect(Collectors.toList());
                System.out.println("FlatMap: " + flatMapped);

                // 5️⃣ distinct
                List<String> distinct = names.stream()
                                .distinct()
                                .collect(Collectors.toList());
                System.out.println("Distinct: " + distinct);

                // 6️⃣ sorted (natural order)
                List<String> sorted = names.stream()
                                .sorted()
                                .collect(Collectors.toList());
                System.out.println("Sorted (natural): " + sorted);

                // 7️⃣ sorted (custom order)
                List<String> sortedDesc = names.stream()
                                .sorted(Comparator.reverseOrder())
                                .collect(Collectors.toList());
                System.out.println("Sorted (reverse): " + sortedDesc);

                // 8️⃣ peek
                System.out.print("Peek: ");
                names.stream()
                                .peek(System.out::print)
                                .collect(Collectors.toList());
                System.out.println();

                // 9️⃣ limit
                List<String> limited = names.stream()
                                .limit(3)
                                .collect(Collectors.toList());
                System.out.println("Limit(3): " + limited);

                // 🔟 skip
                List<String> skipped = names.stream()
                                .skip(2)
                                .collect(Collectors.toList());
                System.out.println("Skip(2): " + skipped);

                // 1️⃣1️⃣ takeWhile (Java 9+)
                List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
                List<Integer> takeWhileList = numbers.stream()
                                .takeWhile(n -> n < 4)
                                .collect(Collectors.toList());
                System.out.println("TakeWhile (<4): " + takeWhileList);

                // 1️⃣2️⃣ dropWhile (Java 9+)
                List<Integer> dropWhileList = numbers.stream()
                                .dropWhile(n -> n < 4)
                                .collect(Collectors.toList());
                System.out.println("DropWhile (<4): " + dropWhileList);
        }
}
