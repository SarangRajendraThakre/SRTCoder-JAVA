package StreamAPI;

import java.util.*;
import java.util.function.Supplier;

public class P4_SupplierDemo {

    public void runSupplierExamples() {
        // 1️⃣ Basic Supplier: supply a fixed string
        Supplier<String> stringSupplier = () -> "Hello, Supplier!";
        System.out.println("String Supplier: " + stringSupplier.get());

        // 2️⃣ Supplier for random number
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random number: " + randomSupplier.get());
        System.out.println("Another random number: " + randomSupplier.get());

        // 3️⃣ Supplier for current date
        Supplier<Date> dateSupplier = () -> new Date();
        System.out.println("Current date: " + dateSupplier.get());

        // 4️⃣ Using Supplier in a Stream (generate)
        System.out.println("\nUsing Supplier with Stream.generate():");
        Supplier<Integer> numberSupplier = new Supplier<>() {
            private int n = 1;

            @Override
            public Integer get() {
                return n++;
            }
        };

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            numbers.add(numberSupplier.get());
        }
        System.out.println(numbers); // [1, 2, 3, 4, 5]
    }

    public static void main(String[] args) {
        P4_SupplierDemo demo = new P4_SupplierDemo();
        demo.runSupplierExamples();
    }
}
