
import java.util.*;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        // Creating a LinkedHashSet of Integers
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();

        // Adding elements
        numbers.add(50);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        numbers.add(10);  // duplicate, ignored
        numbers.add(null); // null allowed

        System.out.println("LinkedHashSet elements (in insertion order): " + numbers);

        // Checking size
        System.out.println("Size: " + numbers.size());

        // Check if element exists
        System.out.println("Contains 20? " + numbers.contains(20));
        System.out.println("Contains 99? " + numbers.contains(99));

        // Removing element
        numbers.remove(30);
        System.out.println("After removing 30: " + numbers);

        // Iterating
        System.out.println("\nIterating using for-each loop:");
        for (Integer num : numbers) {
            System.out.println(num);
        }

        // Iterating using Iterator
        System.out.println("\nIterating using Iterator:");
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // isEmpty
        System.out.println("\nIs empty? " + numbers.isEmpty());

        // Cloning
        LinkedHashSet<Integer> cloned = (LinkedHashSet<Integer>) numbers.clone();
        System.out.println("Cloned LinkedHashSet: " + cloned);

        // Clearing
        numbers.clear();
        System.out.println("After clear(): " + numbers);
    }
}
