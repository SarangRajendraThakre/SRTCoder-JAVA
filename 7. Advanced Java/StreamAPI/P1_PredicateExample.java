
package StreamAPI ;
import java.util.function.Predicate;

public class P1_PredicateExample {

    public void runPredicateExamples() {
        // Basic Predicate: check if number is even
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // Another Predicate: check if number is greater than 10
        Predicate<Integer> greaterThan10 = n -> n > 10;

        // test()
        System.out.println("12 is even? " + isEven.test(12)); // true
        System.out.println("7 is even? " + isEven.test(7));   // false

        // and()
        Predicate<Integer> evenAndGreaterThan10 = isEven.and(greaterThan10);
        System.out.println("12 is even and >10? " + evenAndGreaterThan10.test(12)); // true
        System.out.println("8 is even and >10? " + evenAndGreaterThan10.test(8));   // false

        // or()
        Predicate<Integer> evenOrGreaterThan10 = isEven.or(greaterThan10);
        System.out.println("12 is even or >10? " + evenOrGreaterThan10.test(12)); // true
        System.out.println("7 is even or >10? " + evenOrGreaterThan10.test(7));   // false
        System.out.println("11 is even or >10? " + evenOrGreaterThan10.test(11)); // true

        // negate()
        System.out.println("12 is NOT even? " + isEven.negate().test(12)); // false
        System.out.println("7 is NOT even? " + isEven.negate().test(7));   // true

        // Predicate.not() - alternative way to negate
        System.out.println("Using Predicate.not(): 12 is NOT even? " + Predicate.not(isEven).test(12)); // false
        System.out.println("Using Predicate.not(): 7 is NOT even? " + Predicate.not(isEven).test(7));   // true


        // isEqual()
        Predicate<String> isEqualToHello = Predicate.isEqual("hello");
        System.out.println("'hello' equals 'hello'? " + isEqualToHello.test("hello")); // true
        System.out.println("'world' equals 'hello'? " + isEqualToHello.test("world")); // false
    }

    public static void main(String[] args) {
        P1_PredicateExample demo = new P1_PredicateExample();
        demo.runPredicateExamples();
    }
}
