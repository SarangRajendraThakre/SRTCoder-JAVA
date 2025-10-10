import java.util.*;

public class P6_SubSetExample {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        SortedSet<Integer> sub = set.subSet(20, 40); // 20 <= elements < 40
        System.out.println("Original set: " + set); // [10, 20, 30, 40, 50]
        System.out.println("SubSet (20-40): " + sub); // [20, 30]
    }
}
