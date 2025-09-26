package StreamAPI;

import java.util.*;
import java.util.stream.*;

public class P13_TerminalOperationsDemo {
    public static void main(String[] args) {
        // forEach() & forEachOrdered()

        // collect()

        // reduce()

        // count()

        // anyMatch(), allMatch(), noneMatch()

        // findFirst(), findAny()

        // max(), min()

        // toArray()

        // Primitive stream operations: sum(), average(), summaryStatistics()

        List<String> names = Arrays.asList("Java", "Spring", "Hibernate", "C++", "Python", "Java");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Original names list: " + names);
        System.out.println("Original numbers list: " + numbers);

        // 1️⃣ forEach
        System.out.println("\nforEach:");
        names.stream().forEach(System.out::println);

        // 2️⃣ forEachOrdered
        System.out.println("\nforEachOrdered (parallel stream):");
        names.parallelStream().forEachOrdered(System.out::println);

        // 3️⃣ collect
        System.out.println("\ncollect:");
        List<String> collected = names.stream().filter(s -> s.startsWith("J")).collect(Collectors.toList());
        System.out.println(collected);

        // 4️⃣ reduce
        System.out.println("\nreduce:");
        Optional<Integer> sumOptional = numbers.stream().reduce(Integer::sum);
        sumOptional.ifPresent(sum -> System.out.println("Sum: " + sum));

        int sumWithIdentity = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum with identity: " + sumWithIdentity);

        // 5️⃣ count
        System.out.println("\ncount:");
        long count = names.stream().filter(s -> s.length() > 4).count();
        System.out.println("Count of names with length > 4: " + count);

        // 6️⃣ anyMatch, allMatch, noneMatch
        System.out.println("\nMatch operations:");
        boolean anyJava = names.stream().anyMatch(s -> s.equals("Java"));
        boolean allStartWithJ = names.stream().allMatch(s -> s.startsWith("J"));
        boolean noneStartWithZ = names.stream().noneMatch(s -> s.startsWith("Z"));
        System.out.println("anyMatch(Java): " + anyJava);
        System.out.println("allMatch(start with J): " + allStartWithJ);
        System.out.println("noneMatch(start with Z): " + noneStartWithZ);

        // 7️⃣ findFirst, findAny
        System.out.println("\nFind operations:");
        names.stream().findFirst().ifPresent(n -> System.out.println("findFirst: " + n));
        names.parallelStream().findAny().ifPresent(n -> System.out.println("findAny (parallel): " + n));

        // 8️⃣ max, min
        System.out.println("\nMax & Min:");
        names.stream().max(Comparator.naturalOrder()).ifPresent(n -> System.out.println("Max: " + n));
        names.stream().min(Comparator.naturalOrder()).ifPresent(n -> System.out.println("Min: " + n));

        // 9️⃣ toArray
        System.out.println("\ntoArray:");
        Object[] arr = names.stream().toArray();
        System.out.println(Arrays.toString(arr));

        // 🔟 Primitive stream operations: sum, average, summaryStatistics
        System.out.println("\nPrimitive stream operations:");
        IntStream intStream = numbers.stream().mapToInt(Integer::intValue);
        System.out.println("Sum: " + intStream.sum());

        DoubleStream doubleStream = numbers.stream().mapToDouble(Integer::doubleValue);
        System.out.println("Average: " + doubleStream.average().orElse(0));

        IntSummaryStatistics stats = numbers.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("SummaryStatistics: " + stats);
    }
}
