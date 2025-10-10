import java.util.*;

public class P5_TailSetExample {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        SortedSet<Integer> tail = set.tailSet(30); // elements >= 30
        System.out.println("Original set: " + set); // [10, 20, 30, 40, 50]
        System.out.println("TailSet (>=30): " + tail); // [30, 40, 50]
    }
}
