import java.util.*;

public class P4_HeadSetExample {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        SortedSet<Integer> head = set.headSet(30); // elements < 30
        System.out.println("Original set: " + set); // [10, 20, 30, 40, 50]
        System.out.println("HeadSet (<30): " + head); // [10, 20]
    }
}
