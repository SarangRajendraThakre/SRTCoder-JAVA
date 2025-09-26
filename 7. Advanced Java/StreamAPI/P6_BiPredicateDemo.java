package StreamAPI;
import java.util.function.BiPredicate;

public class P6_BiPredicateDemo {

    public static void main(String[] args) {

        // 1️⃣ Basic BiPredicate: check if first number is greater than second
        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        System.out.println("10 > 5? " + isGreater.test(10, 5)); // true
        System.out.println("5 > 10? " + isGreater.test(5, 10)); // false

        // 2️⃣ BiPredicate: check if sum is even
        BiPredicate<Integer, Integer> sumIsEven = (a, b) -> (a + b) % 2 == 0;
        System.out.println("10 + 4 is even? " + sumIsEven.test(10, 4)); // true
        System.out.println("10 + 5 is even? " + sumIsEven.test(10, 5)); // false

        // 3️⃣ Using negate(): invert a BiPredicate
        BiPredicate<Integer, Integer> notGreater = isGreater.negate();
        System.out.println("10 > 5? (negated) " + notGreater.test(10, 5)); // false
        System.out.println("5 > 10? (negated) " + notGreater.test(5, 10)); // true

        // 4️⃣ Using and(): combine two BiPredicates
        BiPredicate<Integer, Integer> greaterAndEvenSum = isGreater.and(sumIsEven);
        System.out.println("10>4 and sum even? " + greaterAndEvenSum.test(10, 4)); // true
        System.out.println("10>5 and sum even? " + greaterAndEvenSum.test(10, 5)); // false

        // 5️⃣ Using or(): combine two BiPredicates
        BiPredicate<Integer, Integer> greaterOrEvenSum = isGreater.or(sumIsEven);
        System.out.println("10>4 or sum even? " + greaterOrEvenSum.test(10, 4)); // true
        System.out.println("10>5 or sum even? " + greaterOrEvenSum.test(10, 5)); // true
        System.out.println("3>5 or sum even? " + greaterOrEvenSum.test(3, 5));   // false

        // 6️⃣ Another practical example: check strings equality ignoring case
        BiPredicate<String, String> equalsIgnoreCase = (s1, s2) -> s1.equalsIgnoreCase(s2);
        System.out.println("'Hello' equalsIgnoreCase 'hello'? " + equalsIgnoreCase.test("Hello", "hello")); // true
        System.out.println("'Hello' equalsIgnoreCase 'world'? " + equalsIgnoreCase.test("Hello", "world")); // false
    }
}
