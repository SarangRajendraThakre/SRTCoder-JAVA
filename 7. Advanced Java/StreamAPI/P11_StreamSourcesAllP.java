package StreamAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class P11_StreamSourcesAllP {

    public static void main(String[] args) {

        // 1 from the collection
        System.out.println("----------------------Stream from the Collection-------------------------");

        List<String> list = Arrays.asList("SArang", "Vidya", "Thakre", "Yadnesh");
        Stream<String> StreamList = list.stream();
        StreamList.forEach(System.out::println);

        // 2 Stream from an Array

        System.out.println("----------------------Stream from the Array-------------------------");

        String[] arr = { "Sarang", "Vidya", "Yadnesh" };
        Stream<String> arrayStream = Arrays.stream(arr);
        arrayStream.forEach(System.out::println);

        // 3 stream using stream.of()
        System.out.println("----------------------Stream from the Stream.of-------------------------");

        Stream<String> ofStream = Stream.of("one", "Two", "Three");
        ofStream.forEach(System.out::println);

        // 4 stream using stream.builder()
        System.out.println(
                "----------------------steam using Stream.builder()------------------------------------------");

        Stream<String> StreamBuilder = Stream.<String>builder()
                .add("java")
                .add("python")
                .add("js")
                .build();

        StreamBuilder.forEach(System.out::println);

        // 5 Stream using Stream.generate(null) Infinite stream

        System.out.println("-----------------------Stream.generate()------------------------------------");
        Stream<Integer> generatedStream = Stream.generate(() -> new Random().nextInt(100));
        generatedStream.limit(5).forEach(System.out::println);

        // 6 Stream using Stream.iterate() -> infinite Stream
        System.out.println(
                "-----------------------Stream.iterate()-----------------------------------------------------");

        Stream<Integer> itereateStream = Stream.iterate(1, n -> n * 2);
        itereateStream.limit(5).forEach(System.out::println);

        // 7 Stream from primitive streams (IntStream, LongStream, DoubleStream)

        IntStream intStream = IntStream.range(0, 10);
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

        try (Stream<String> lines = Files
                .lines(Paths.get("E:\\SRTCoder JAVA\\7. Advanced Java\\StreamAPI\\test.txt"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 🔟 Stream.empty()
        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println); // prints nothing

    }
}