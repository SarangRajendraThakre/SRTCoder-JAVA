import java.util.*;

public class P3_LastExample {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>(Arrays.asList(50, 10, 30, 20));
        System.out.println("Set: " + set);       // [10, 20, 30, 50]
        System.out.println("Last element: " + set.last()); // 50
    }
}
