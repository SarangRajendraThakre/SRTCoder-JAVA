public class P32_Str_Distinct_Word_in_String {

    public static void main(String[] args) {

        String str = "java hello java hie hello hello bye ";
        
        // Correct way to split the string into words
        String[] arr = str.trim().split("\\s+");

        boolean[] track = new boolean[arr.length];
        for (int i = 0, cnt = 0; i < arr.length; i++, cnt = 0) {
            if (track[i]) {
                continue;
            }

            for (int j = i; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    cnt++;
                    track[j] = true;
                }
            }

          
                System.out.println(arr[i] );
            
        }
    }
}