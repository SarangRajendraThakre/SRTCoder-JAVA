import java.util.Set;
import java.util.List;

public class SetDemo {
    public static void main(String[] args) {
        // 1. Empty unmodifiable set
        Set<String> emptySet = Set.of();
        System.out.println("Empty set: " + emptySet);

        // 2. Single element unmodifiable set
        Set<String> singleSet = Set.of("Java");
        System.out.println("Single element set: " + singleSet);

        // 3. Multiple elements unmodifiable set
        Set<String> multiSet = Set.of("Java", "Python", "C++");
        System.out.println("Multiple element set: " + multiSet);

        // 4. Copy of existing collection
        List<String> languages = List.of("Go", "Rust", "Kotlin");
        Set<String> copiedSet = Set.copyOf(languages);
        System.out.println("Copied set: " + copiedSet);

        // 5. Trying to modify an unmodifiable set
        try {
            multiSet.add("JavaScript"); // This will throw exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify multiSet! It's unmodifiable.");
        }
    }
}


// https://chatgpt.com/c/68d8d121-1530-832f-bc19-3070d5c729cc