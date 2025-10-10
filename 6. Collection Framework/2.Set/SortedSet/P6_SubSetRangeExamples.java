import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;


public class P6_SubSetRangeExamples {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));

        // Create a subset view from 20 (inclusive) to 40 (exclusive)
        SortedSet<Integer> subSet = set.subSet(20, 40);
        System.out.println("Subset View: " + subSet); // [20, 30]

        // Valid addition inside range
        subSet.add(25);
        System.out.println("After adding 25: " + subSet); // [20, 25, 30]

        // Invalid addition outside range
        subSet.add(45); // ❌ Throws IllegalArgumentException
    }
}
