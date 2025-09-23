public class P53_Str_Sort_Characters_of_String_Alphabetically {

    public static void main(String[] args) {
        String originalString = "programming";
        String sortedString = sortString(originalString);

        System.out.println("Original String: " + originalString);
        System.out.println("Sorted String:   " + sortedString);
    }

    public static String sortString(String inputStr) {
        
        char[] charArray = inputStr.toCharArray();
        int n = charArray.length;

        
        
        for (int i = 0; i < n - 1; i++) {
            
            for (int j = 0; j < n - i - 1; j++) {
                
                if (charArray[j] > charArray[j+1]) {
                    char temp = charArray[j];
                    charArray[j] = charArray[j+1];
                    charArray[j+1] = temp;
                }
            }
        }

        
        return new String(charArray);
    }
}