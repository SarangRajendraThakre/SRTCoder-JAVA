import java.util.LinkedHashSet;
import java.util.Set;

public class P50_Str_LongestNonRepeatingSubString {

    public static void main(String[] args) {

        String str = "abcaabcdeabcfghiabcab";

        Set<String> list = new LinkedHashSet<>();

        for (int i = 0; i < str.length(); i++) {
            String s = str.charAt(i) + "";
            for (int j = i + 1; j < str.length(); j++) {
                if (checkingNOtContain(s, str.charAt(j))) {
                    s += str.charAt(j);
                    list.add(s);
                } else {
                    list.add(s);
                    break;
                }
            }
        }
        System.out.println(list);
    }

    public static boolean checkingNOtContain(String str, char ch) {
        for (char ele : str.toCharArray()) {
            if (ele == ch)
                return false;
        }
        return true;
    }
}
