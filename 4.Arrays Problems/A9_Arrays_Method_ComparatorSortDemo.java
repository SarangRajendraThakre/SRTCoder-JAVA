import java.util.Arrays;
import java.util.Comparator;

public class A9_Arrays_Method_ComparatorSortDemo {

    private static int countVowels(String str) {
        int count = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] fruits = { "Banana", "Pineapple", "Apple", "Kiwi" };
        System.out.println("Original array: " + Arrays.toString(fruits));

        Comparator<String> Alphabetical = (s1, s2) -> s1.compareTo(s2);

        Comparator<String> reverseAlphabetical = (s1, s2) -> s2.compareTo(s1);

        Comparator<String> sortByLength = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        Comparator<String> byLengthDescending = (s1, s2) -> Integer.compare(s2.length(), s1.length());

        Comparator<String> byLengthThenAlpha = Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder());

        Comparator<String> byLastChar = (s1, s2) -> {
            char last1 = s1.charAt(s1.length() - 1);
            char last2 = s2.charAt(s2.length() - 1);
            return Character.compare(last1, last2);
        };

        Comparator<String> caseInsensitive = (s1, s2) -> s1.compareToIgnoreCase(s2);

        Comparator<String> byVowelCount = Comparator.comparingInt(s -> countVowels(s));

     

        // byLengthDescending
        // byLastChar
        // sortByLength

        Arrays.sort(fruits, byVowelCount);

        System.out.println("Sorted by length: " + Arrays.toString(fruits));
    }
}