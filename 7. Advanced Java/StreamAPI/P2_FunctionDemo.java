
package StreamAPI;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P2_FunctionDemo {

    public void runFunctionExamples() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 1️⃣ Function: square a number
        Function<Integer, Integer> square = n -> n * n;

        // Using apply()
        System.out.println("----------apply()---------------");
        System.out.println(square.apply(3));
        System.out.println("Squares:");
        numbers.forEach(n -> System.out.println(square.apply(n)));

        // 2️⃣ Function: add 10
        Function<Integer, Integer> addTen = n -> n + 10;

        // andThen(): square first, then add 10
        System.out.println("----------andThen()---------------");

        Function<Integer, Integer> squareThenAdd = square.andThen(addTen);
        System.out.println("\nSquare then add 10:");
        numbers.forEach(n -> System.out.println(squareThenAdd.apply(n)));

        // compose(): add 10 first, then square
        System.out.println("----------compose()---------------");

        Function<Integer, Integer> addThenSquare = square.compose(addTen);
        System.out.println("\nAdd 10 then square:");
        numbers.forEach(n -> System.out.println(addThenSquare.apply(n)));

        // 3️⃣ identity(): returns the same value
        System.out.println("----------identity()---------------");

        Function<Integer, Integer> identityFunc = Function.identity();
        System.out.println("\nIdentity function:");
        numbers.forEach(n -> System.out.println(identityFunc.apply(n)));

        // 4️⃣ Using Function in a Stream

        System.out.println("----------Using Function in a Stream---------------");

        System.out.println("\nUsing Function with Stream map():");
        List<Integer> squaredList = numbers.stream()
                .map(square) // apply square function
                .collect(Collectors.toList());
        System.out.println(squaredList);
    }

    public static void main(String[] args) {
        P2_FunctionDemo demo = new P2_FunctionDemo();
        demo.runFunctionExamples();
    }
}
