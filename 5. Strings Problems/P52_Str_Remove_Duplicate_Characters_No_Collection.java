public class P52_Str_Remove_Duplicate_Characters_No_Collection {

    public static void main(String[] args) {
        String originalString = "programming";
        String uniqueString = removeDuplicates(originalString);

        System.out.println("Original String: " + originalString);
        System.out.println("After Removing Duplicates: " + uniqueString);
    }

    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String result = ""; 

        // Loop through each character of the input string
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

                  if (result.indexOf(currentChar) == -1) {
                // If not found, append it to the result
                result += currentChar;
            }
        }

        return result;
    }
}