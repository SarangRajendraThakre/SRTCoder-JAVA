

import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        // Creating a HashSet of Strings
        HashSet<String> fruits = new HashSet<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Banana"); // duplicate, will NOT be added
        fruits.add(null);     // null is allowed

        System.out.println("HashSet elements: " + fruits);

        // Checking size
        System.out.println("Size: " + fruits.size());

        // Check if an element exists
        System.out.println("Contains Mango? " + fruits.contains("Mango"));
        System.out.println("Contains Grapes? " + fruits.contains("Grapes"));

        // Removing elements
        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);

        // Iterating (unordered output)
        System.out.println("\nIterating using Iterator:");
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nIterating using for-each:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // isEmpty check
        System.out.println("\nIs HashSet empty? " + fruits.isEmpty());

        // Cloning
        HashSet<String> clonedSet = (HashSet<String>) fruits.clone();
        System.out.println("Cloned HashSet: " + clonedSet);

        // Clearing all elements
        fruits.clear();
        System.out.println("After clear(): " + fruits);
    }
}
