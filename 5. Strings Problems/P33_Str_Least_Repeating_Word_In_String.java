public class P33_Str_Least_Repeating_Word_In_String {

    public static void main(String[] args) {
        
        String str = "java hello java hie hello hello java bye java";
        String[] arr = str.split(" ");
        boolean[] track = new boolean[arr.length];

        int leastCnt = Integer.MAX_VALUE;
        String lowestRepeatingString = null;

        for(int i = 0, cnt = 0; i < arr.length; i++, cnt = 0) {
            if(track[i]) continue;

            // Inner loop to count ALL occurrences of arr[i]
            for(int j = i; j < arr.length; j++) {
                if(arr[i].equals(arr[j])) {
                    cnt++;
                    track[j] = true;
                }
            }
            
            // BUG FIX: Check the count AFTER the inner loop is finished
            if(cnt < leastCnt) {
                leastCnt = cnt;
                lowestRepeatingString = arr[i];
            }
        }

        System.out.println("The original string is: " + str);
        System.out.println("The least repeating word is: " + lowestRepeatingString + " (Count: " + leastCnt + ")");
    }
}