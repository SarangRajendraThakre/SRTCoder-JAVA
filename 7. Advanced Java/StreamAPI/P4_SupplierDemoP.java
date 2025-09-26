package StreamAPI;

import java.util.*;
import java.util.function.Supplier;

public class P4_SupplierDemoP {

    public void runSupplierExamples() {
        Supplier<String> greet = () -> "Hello";

        Supplier<Double> randomNumber = () -> Math.random();

        Supplier<Date> date = () -> new Date();

        System.out.println("-------------------get()---------------------");

        System.out.println(greet.get());
        System.out.println(randomNumber.get());
        System.out.println(date.get());

        System.out.println(
                "----------------------making the obj of functional inteface supplier ------------------------");

                // anonyms inner class
        Supplier<Integer> numberGenerator = new Supplier<Integer>() {
            private int n = 1;

            public Integer get() {
                return n++;
            }
        };

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(numberGenerator.get());
        }
        System.out.println(list);

    }

    public static void main(String[] args) {
        P4_SupplierDemoP demo = new P4_SupplierDemoP();
        demo.runSupplierExamples();
    }
}
