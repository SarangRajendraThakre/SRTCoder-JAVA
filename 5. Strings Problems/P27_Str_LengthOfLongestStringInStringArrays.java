import java.util.Arrays;
import java.util.Comparator;

public class P27_Str_LengthOfLongestStringInStringArrays {

    public static void main(String[] args) {
        // Your code here

        String[] strArr = { "Sarang", "Yadnesh", "Thakre", "vidya", "Srikanth" };

        usingNormalTraditional(strArr);
        usingTheStreamApi(strArr);

    }

    public static void usingNormalTraditional(String[] strArr) {

        int maxLength = Integer.MIN_VALUE;
        int element = Integer.MIN_VALUE;
        for (int i = 0; i < strArr.length; i++) {
            if (maxLength < strArr[i].length()) {
                maxLength = strArr[i].length();
                element = i;
            }

        }

        System.out.println(strArr[element] + " is the words or String which is Longest of size " + maxLength
                + " in the String Array of   \n" + Arrays.toString(strArr));

    }

    public static void usingTheStreamApi(String[] strArr) {
        // Find longest string length
        int longestLength = Arrays.stream(strArr)
                .mapToInt(String::length)
                .max()
                .orElse(0);

        // Find longest string itself
        String longestString = Arrays.stream(strArr)
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println("Longest length = " + longestLength);
        System.out.println("Longest string = " + longestString);
    }

}
