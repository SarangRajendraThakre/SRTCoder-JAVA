public class P54_Str_Capitalize_First_letter_of_Each_Word {

    public static void main(String[] args) {
        String str = "i am sarang";
        String str2 = capitalize(str);

        System.out.println("Original: " + str);
        System.out.println("Capitalized: " + str2);
    }

  
    public static String capitalize(String str) {
     
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.split(" ");
        String capitalizedString = ""; 

        for (String word : words) {
            if (!word.isEmpty()) {
                String firstLetter = word.substring(0, 1).toUpperCase();
                String restOfWord = word.substring(1);

                // Use the += operator to build the new string
                capitalizedString += firstLetter + restOfWord + " ";
            }
        }

        // Remove the trailing space and return
        return capitalizedString.trim();
    }
}