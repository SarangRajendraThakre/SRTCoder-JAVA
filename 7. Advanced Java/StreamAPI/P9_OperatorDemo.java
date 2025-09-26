package StreamAPI;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;

public class P9_OperatorDemo {
    public static void main(String[] args) {

        // ----------------- UnaryOperator -----------------
        System.out.println("===== UnaryOperator Demo =====");

        // 1️⃣ Basic: convert string to uppercase
        UnaryOperator<String> toUpper = str -> str.toUpperCase();
        System.out.println("Uppercase: " + toUpper.apply("sarang"));

        // 2️⃣ Square a number
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println("Square of 6: " + square.apply(6));

        // 3️⃣ Using replaceAll with UnaryOperator
        List<String> names = new ArrayList<>(Arrays.asList("sarang", "rajendra", "thakre"));
        UnaryOperator<String> capitalize = name -> name.substring(0, 1).toUpperCase() + name.substring(1);
        names.replaceAll(capitalize);
        System.out.println("Capitalized Names: " + names);

        // 4️⃣ Chaining with andThen() and compose()
        UnaryOperator<Integer> increment = x -> x + 1;
        UnaryOperator<Integer> triple = x -> x * 3;

        System.out.println("Increment then triple (5): " + increment.andThen(triple).apply(5)); // (5+1)*3=18
        System.out.println("Triple then increment (5): " + increment.compose(triple).apply(5)); // (5*3)+1=16

        // ----------------- BinaryOperator -----------------
        System.out.println("\n===== BinaryOperator Demo =====");

        // 1️⃣ Add two numbers
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("Add 10 + 20 = " + add.apply(10, 20));

        // 2️⃣ Find max of two numbers
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
        System.out.println("Max of 15 and 25 = " + max.apply(15, 25));

        // 3️⃣ Concatenate two strings
        BinaryOperator<String> concat = (s1, s2) -> s1 + " " + s2;
        System.out.println("Concat: " + concat.apply("Sarang", "Thakre"));

        // 4️⃣ Using reduce in streams with BinaryOperator
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        int product = numbers.stream().reduce(1, multiply);
        System.out.println("Product of list = " + product);
    }
}
