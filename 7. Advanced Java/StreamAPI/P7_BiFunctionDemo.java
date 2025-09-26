package StreamAPI;
import java.util.function.BiFunction;
import java.util.function.Function;

public class P7_BiFunctionDemo {

    public static void main(String[] args) {

        // 1️⃣ Basic BiFunction: sum two integers
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println("Sum of 5 and 10: " + sum.apply(5, 10)); // 15

        // 2️⃣ BiFunction: concatenate two strings
        BiFunction<String, String, String> concat = (s1, s2) -> s1 + s2;
        System.out.println("Concat 'Hello' and 'World': " + concat.apply("Hello", "World"));

        // 3️⃣ Using andThen(): chain a Function after BiFunction
        Function<Integer, String> convertToString = result -> "Result = " + result;
        BiFunction<Integer, Integer, String> sumThenString = sum.andThen(convertToString);

        System.out.println(sumThenString.apply(7, 3)); // Result = 10

        // 4️⃣ Another example: multiply two numbers then convert to string
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        BiFunction<Integer, Integer, String> multiplyThenString = multiply.andThen(result -> "Multiplication = " + result);

        System.out.println(multiplyThenString.apply(4, 5)); // Multiplication = 20
    }
}
