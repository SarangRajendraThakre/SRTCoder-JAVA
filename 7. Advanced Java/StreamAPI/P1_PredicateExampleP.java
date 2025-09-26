
package StreamAPI;

import java.util.function.Predicate;

public class P1_PredicateExampleP {

    public void runPredicateExamples() {

        Predicate<Integer> isEven = s -> s % 2 == 0;
        Predicate<Integer> isGreaterThan20 = s -> s > 20;

        // testing the Predicate

        System.out.println("-------------------testing the predicate----------------------");

        System.out.println(isEven.test(10));
        System.out.println(isGreaterThan20.test(21));

        System.out.println("-------------------or----------------------");

        Predicate<Integer> isEvenOrisGreater = isEven.or(isGreaterThan20);
        System.out.println("isEvenOrisGreater 1" + isEvenOrisGreater.test(3));

        System.out.println("isEvenOrisGreater 2 " + isEvenOrisGreater.test(4));

        System.out.println("isEvenOrisGreater 3 " + isEvenOrisGreater.test(22));

        System.out.println("-------------------and----------------------");

        Predicate<Integer> isEvenAndisGreater = isEven.and(isGreaterThan20);
        System.out.println(isEvenAndisGreater.test(4));

        System.out.println(isEvenAndisGreater.test(23));
        System.out.println(isEvenAndisGreater.test(24));

        System.out.println("-------------------negate----------------------");

        Predicate<Integer> isEvenNegate = isEven.negate();
        System.out.println(isEvenNegate.test(4));

        Predicate<Integer> isGreaterThan20Negate = isGreaterThan20.negate();

        System.out.println(isGreaterThan20Negate.test(4));

        System.out.println("-------------------Not----------------------");

         Predicate<Integer> notEven = Predicate.not(isEven);
         System.out.println(Predicate.not(isEven).test(40));
         System.out.println(notEven.test(59));


        System.out.println("-------------------isEqual----------------------");

        Predicate<String> isEqualtoSarang = Predicate.isEqual("Sarang");
        System.out.println(isEqualtoSarang.test("sarang")); 
        System.out.println(isEqualtoSarang.test("Sarang")); 



  
    }

    public static void main(String[] args) {
        P1_PredicateExampleP demo = new P1_PredicateExampleP();
        demo.runPredicateExamples();
    }
}
