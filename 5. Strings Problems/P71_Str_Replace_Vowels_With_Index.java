
public class P71_Str_Replace_Vowels_With_Index {

    // write a java program to replace all vowels with there position in the string
    public static void main(String[] args) {

        String str = "Hello";
        str.toLowerCase();

        System.out.println(replaceVowelsWithIndex(str));

    }

    public static String replaceVowelsWithIndex(String str) {
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if (checkVowels(str.charAt(i))) {
                s += i;

            } else {
                s += str.charAt(i);
            }

        }

        return s;
    }

    public static boolean checkVowels(char ch) {

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
}
