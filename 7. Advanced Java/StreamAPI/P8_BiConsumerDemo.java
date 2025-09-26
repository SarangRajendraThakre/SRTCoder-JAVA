package StreamAPI;
import java.util.function.BiConsumer;

public class P8_BiConsumerDemo {

    public static void main(String[] args) {

        // 1️⃣ Basic BiConsumer: print two values
        BiConsumer<String, Integer> printNameAndAge = (name, age) -> 
            System.out.println(name + " is " + age + " years old");

        printNameAndAge.accept("Alice", 25);
        printNameAndAge.accept("Bob", 30);

        // 2️⃣ BiConsumer: sum two numbers and print
        BiConsumer<Integer, Integer> sumNumbers = (a, b) -> 
            System.out.println("Sum = " + (a + b));

        sumNumbers.accept(10, 5);
        sumNumbers.accept(7, 3);

        // 3️⃣ andThen(): chain two BiConsumers
        BiConsumer<String, String> printFullName = (first, last) -> System.out.println("Full Name: " + first + " " + last);
        BiConsumer<String, String> printNameLength = (first, last) -> System.out.println("Length: " + (first.length() + last.length()));

        BiConsumer<String, String> combinedBiConsumer = printFullName.andThen(printNameLength);

        combinedBiConsumer.accept("Sarang", "Thakre");
        combinedBiConsumer.accept("Alice", "Johnson");
    }
}
