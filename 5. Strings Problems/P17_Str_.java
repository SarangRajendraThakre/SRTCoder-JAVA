public class P17_Str_ {

    public static String reverse(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "I love India";
        String[] words = str.split(" ");

        String reversedSentence = "";

        for (String word : words) {

            reversedSentence += reverse(word) + " ";
        }

        System.out.println(reversedSentence.trim());
    }
}