public class ReverseStringExceptSpecial {

    public static boolean isSpecial(char ch) {
        return ch == '@' || ch == '-' || ch == '$';
    }

    public static String reverseStringAndCheck(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {

            // Skip special characters from left
            if (isSpecial(chars[left])) {
                left++;
                continue;
            }

            // Skip special characters from right
            if (isSpecial(chars[right])) {
                right--;
                continue;
            }

            // Swap normal characters
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String inputString = "he@ll$o-world";
        String reversedString = reverseStringAndCheck(inputString);

        System.out.println("Original String: " + inputString);
        System.out.println("Reversed String: " + reversedString);
    }
}
