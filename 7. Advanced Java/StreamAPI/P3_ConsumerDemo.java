package StreamAPI;

import java.util.*;
import java.util.function.Consumer;

public class P3_ConsumerDemo {

    public void runConsumerExamples() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // 1️⃣ Basic Consumer: print name
        Consumer<String> printName = name -> System.out.println("Name: " + name);

        System.out.println("Using accept():");
        names.forEach(printName); // or names.forEach(name -> printName.accept(name));

        // 2️⃣ Another Consumer: print length of name
        Consumer<String> printLength = name -> System.out.println("Length: " + name.length());

        // 3️⃣ andThen(): first print name, then print length
        Consumer<String> combinedConsumer = printName.andThen(printLength);

        System.out.println("\nUsing andThen():");
        names.forEach(combinedConsumer);

        // 4️⃣ Using Consumer inside Stream forEach
        System.out.println("\nUsing Consumer in Stream map() and forEach():");
        names.stream()
             .map(String::toUpperCase)
             .forEach(printName); // print uppercase names
    }

    public static void main(String[] args) {
        P3_ConsumerDemo demo = new P3_ConsumerDemo();
        demo.runConsumerExamples();
    }
}
