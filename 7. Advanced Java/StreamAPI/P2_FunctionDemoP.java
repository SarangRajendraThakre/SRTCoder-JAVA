
package StreamAPI;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P2_FunctionDemoP {

    public void runFunctionExamples() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        Function<Integer, Integer> square = n -> n * n;

        Function<Integer, Integer> add20 = n -> n + 20;

        System.out.println("---------------------apply()---------------------------");

        System.out.println(square.apply(9));

        numbers.forEach(n -> System.out.print(square.apply(n) + " "));
        System.out.println();

        System.out.println(add20.apply(10));

        numbers.forEach(n -> System.out.print(add20.apply(n) + " "));
        System.out.println();

        System.out.println("---------------------andThen()---------------------------");

        Function<Integer, Integer> squareAndThenADD20 = square.andThen(add20);
        System.out.println(squareAndThenADD20.apply(4));

        numbers.forEach(n -> System.out.print(squareAndThenADD20.apply(n) + " "));
        System.out.println();

        System.out.println("---------------------compose()---------------------------");

        Function<Integer, Integer> firstADD20Thensquare = square.compose(add20);

        System.out.println(firstADD20Thensquare.apply(2));

        numbers.forEach(n -> System.out.print(firstADD20Thensquare.apply(n) + " "));
        System.out.println();

        System.out.println("---------------------Identity()---------------------------");

        Function<Integer, Integer> identityFunc = Function.identity();

        System.out.println(identityFunc.apply(10));

        numbers.forEach(n -> System.out.print(identityFunc.apply(n) + " "));
        System.out.println();

        System.out.println("---------------------Using the function in Stream---------------------------");

        System.out.println();
        List<Integer> listOfSquare = numbers.stream()
                                     .map(square)
                                     .collect(Collectors.toList());


        System.out.println(listOfSquare);                             


    }

    public static void main(String[] args) {
        P2_FunctionDemoP demo = new P2_FunctionDemoP();
        demo.runFunctionExamples();
    }
}
