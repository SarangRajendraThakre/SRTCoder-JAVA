package StreamAPI;

import java.util.*;
import java.util.function.*;

public class P10_MethodReferenceDemo {
    public static void main(String[] args) {

        // 1️⃣ Reference to a static method
        // 2️⃣ Reference to an instance method of a particular object
        // 3️⃣ Reference to an instance method of an arbitrary object of a particular
        // 4️⃣ Reference to a constructor
        // 5️⃣ Method Reference + Overloading





        // 1️⃣ Reference to a static method
        Function<String, Integer> strLength1 = s -> P10_MethodReferenceDemo.getLength(s);
        Function<String, Integer> strLength2 = P10_MethodReferenceDemo::getLength; // method reference

        System.out.println("Static Method Ref: " + strLength2.apply("Sarang"));

        // 2️⃣ Reference to an instance method of a particular object
        P10_MethodReferenceDemo demo = new P10_MethodReferenceDemo();
        Consumer<String> printer1 = s -> demo.printMessage(s);
        Consumer<String> printer2 = demo::printMessage;
        printer2.accept("Hello from instance method reference!");

        // 3️⃣ Reference to an instance method of an arbitrary object of a particular
        // type
        List<String> names = Arrays.asList("sarang", "rajendra", "thakre");

        // Lambda
        names.forEach(name -> System.out.println(name.toUpperCase()));
        // Method reference (won’t print directly)
        names.forEach(String::toUpperCase);
        // Correct usage
        names.stream().map(String::toUpperCase).forEach(System.out::println);

        // 4️⃣ Reference to a constructor
        Supplier<List<String>> listSupplier1 = () -> new ArrayList<>();
        Supplier<List<String>> listSupplier2 = ArrayList::new;
        List<String> newList = listSupplier2.get();
        newList.add("Constructor Ref Working!");
        System.out.println(newList);

        // 5️⃣ Method Reference + Overloading
        // Overloaded static methods
        Function<String, Integer> lengthFunc = P10_MethodReferenceDemo::getLength; // matches getLength(String)
        Function<Integer, Integer> squareFunc = P10_MethodReferenceDemo::getLength; // matches getLength(Integer)

        System.out.println("Length of 'Hello': " + lengthFunc.apply("Hello")); // 5
        System.out.println("Square of 7: " + squareFunc.apply(7)); // 49
    }

    // 🔹 Overloaded static methods
    public static Integer getLength(String str) {
        return str.length();
    }

    public static Integer getLength(Integer num) {
        return num * num;
    }

    // Instance method
    public void printMessage(String msg) {
        System.out.println("Message: " + msg);
    }
}
