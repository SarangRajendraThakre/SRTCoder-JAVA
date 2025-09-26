package StreamAPI;

import java.util.*;
import java.util.stream.*;

public class P12_IntermediateOperationsP {
        public static void main(String[] args) {

                List<String> names = Arrays.asList("java", "js", "python", "sql", "java");
                System.out.println(names);

                // 1. filter()

                List<String> filtered = names.stream()
                                .filter(s -> s.length() > 3)
                                .collect(Collectors.toList());

                System.out.println(filtered);

                // 2. Map()

                List<Integer> mapped = names.stream()
                                .map(String::length)
                                .collect(Collectors.toList());

                System.out.println(mapped);

                // 3. mapToInt()

                IntStream intStream = names.stream()
                                .mapToInt(String::length);

                intStream.forEach(n -> System.out.print(n));
                System.out.println();

                // 4. flatMap
                List<List<String>> nested = Arrays.asList(
                                Arrays.asList("a", "b"),
                                Arrays.asList("c", "d"));

                List<String> flatMapped = nested.stream()
                                .flatMap(List::stream)
                                .collect(Collectors.toList());
                System.out.println("FlatMapped" + flatMapped);

                // 5 . distinct
                List<String> distinct = names.stream()
                                .distinct()
                                .collect(Collectors.toList());
                System.out.println("Distinct" + distinct);

                // 6 sorted (natural order)
                List<String> sorted = names.stream()
                                .sorted()
                                .collect(Collectors.toList());
                System.out.println("Sorted" + sorted);

                // 7 sorted (custom order)

                List<String> sortedDesc = names.stream()
                                .sorted(Comparator.reverseOrder())
                                .collect(Collectors.toList());
                System.out.println("Sorteddesc" + sortedDesc);

                // 8 peek()

                names.stream()
                                .peek(System.out::print)
                                .collect(Collectors.toList());
                                System.out.println();

               // 9 limit()

                   List<String> limited = names.stream()
                                .limit(2)
                                .collect(Collectors.toList());
                System.out.println("limit" + limited);
               // 10 skip()

                   List<String> skiped = names.stream()
                                .skip(2)
                                .collect(Collectors.toList());
                System.out.println("skiped" + skiped);



        }

}
