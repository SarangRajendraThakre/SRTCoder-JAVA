public class P23_Str_Panagram {

    public static void main(String[] args) {
     
        String str = "abcdefghijklmnopqrstuvwxyZ";

        System.out.println("Input String: " + str);
        if (isPanagram(str)) {
            System.out.println("The string is a pangram.");
        } else {
            System.out.println("The string is NOT a pangram.");
        }
    }

    public static boolean isPanagram(String str) {
        if (str.length() < 26) {
            return false;
        }

        boolean[] visited = new boolean[26];
        String lowerCaseStr = str.toLowerCase();

        for (int i = 0; i < lowerCaseStr.length(); i++) {
            char ch = lowerCaseStr.charAt(i);

            if (ch >= 'a' && ch <= 'z') {

                int index = ch - 'a';

                
                visited[index] = true;
            }
        }

        for (boolean wasVisited : visited) {
            if (!wasVisited) {
                return false; 
            }
        }

        return true;
    }
}


