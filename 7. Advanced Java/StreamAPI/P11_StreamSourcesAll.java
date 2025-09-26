package StreamAPI;

import java.nio.file.Files;
import java.util.*;
import java.util.stream.*;

public class P11_StreamSourcesAll {

    public static void main(String[] args) {

        // ✅ Covered Stream sources:
        
        // From Collection (list.stream())
        // From Array (Arrays.stream(arr))
        // Using Stream.of()
        // Using Stream.builder()
        // Using Stream.generate()
        // Using Stream.iterate()
        // Primitive streams (IntStream, LongStream, DoubleStream)
        // From String (chars())
        // From File (Files.lines)
        // Empty stream (Stream.empty())

        // 1️⃣ Stream from a Collection
        List<String> list = Arrays.asList("Java", "Spring", "Hibernate");
        Stream<String> listStream = list.stream();
        listStream.forEach(System.out::println);

        // 2️⃣ Stream from an Array
        String[] arr = { "Sarang", "Rajendra", "Thakre" };
        Stream<String> arrayStream = Arrays.stream(arr);
        arrayStream.forEach(System.out::println);

        // 3️⃣ Stream using Stream.of()
        Stream<String> ofStream = Stream.of("One", "Two", "Three");
        ofStream.forEach(System.out::println);

        // 4️⃣ Stream using Stream.builder()
        Stream<String> builderStream = Stream.<String>builder()
                .add("Alpha").add("Beta").add("Gamma")
                .build();
        builderStream.forEach(System.out::println);

        // 5️⃣ Stream using Stream.generate() → Infinite Stream
        Stream<Integer> generatedStream = Stream.generate(() -> new Random().nextInt(100));
        generatedStream.limit(5).forEach(System.out::println);

        // 6️⃣ Stream using Stream.iterate() → Infinite Stream
        Stream<Integer> iteratedStream = Stream.iterate(1, n -> n + 2);
        iteratedStream.limit(5).forEach(System.out::println);

        // 7️⃣ Stream from primitive streams (IntStream, LongStream, DoubleStream)
        IntStream intStream = IntStream.range(1, 6); // 1 to 5
        intStream.forEach(System.out::println);

        LongStream longStream = LongStream.rangeClosed(1, 5);
        longStream.forEach(System.out::println);

        DoubleStream doubleStream = new Random().doubles(3); // 3 random doubles
        doubleStream.forEach(System.out::println);

        // 8️⃣ Stream from String (chars)
        String str = "Hello";
        IntStream charStream = str.chars(); // gives Unicode int values
        charStream.forEach(ch -> System.out.println((char) ch));

        // 9️⃣ Stream from File (using Files.lines) – needs try-catch
        // Uncomment below lines if you want file example
        /*
         * try (Stream<String> lines = Files.lines(Paths.get("test.txt"))) {
         * lines.forEach(System.out::println);
         * } catch (IOException e) {
         * e.printStackTrace();
         * }
         */

        // 🔟 Stream.empty()
        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println); // prints nothing
    }
}
