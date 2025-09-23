
import java.util.Arrays;

public class A18_Arrays_Method_parallelPrefix_CumulativeSentence {
    public static void main(String[] args) {
        // An array of words and spaces
        String[] words = {"Java", " ", "is", " ", "powerful"};
        
        System.out.println("Original words: " + Arrays.toString(words));

        // Use parallelPrefix to concatenate strings
        Arrays.parallelPrefix(words, (builtSentence, nextWord) -> builtSentence + nextWord);

        System.out.println("Cumulative sentence parts: " + Arrays.toString(words));
    }
}