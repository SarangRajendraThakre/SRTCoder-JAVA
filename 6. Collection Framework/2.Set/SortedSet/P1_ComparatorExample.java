import java.util.*;

public class P1_ComparatorExample {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>(); // natural order
        System.out.println("Comparator (natural order): " + set.comparator()); // null

        SortedSet<Integer> set2 = new TreeSet<>(Comparator.reverseOrder()); // custom comparator
        set2.addAll(Arrays.asList(10, 20, 30));
        System.out.println("Comparator (reverse order): " + set2.comparator());
        System.out.println("Set in reverse order: " + set2); // [30, 20, 10]
    }
}
