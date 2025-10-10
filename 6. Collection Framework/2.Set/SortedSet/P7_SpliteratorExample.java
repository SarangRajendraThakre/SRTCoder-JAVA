import java.util.*;

public class P7_SpliteratorExample {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        Spliterator<Integer> spliterator = set.spliterator();

        System.out.print("Elements using spliterator: ");
        spliterator.forEachRemaining(e -> System.out.print(e + " ")); // 10 20 30 40 50
    }
}
