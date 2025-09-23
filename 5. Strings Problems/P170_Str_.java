public class P170_Str_ {

    public static void main(String[] args) {
        String s = "Swiss";
        s = s.toLowerCase();

        char[] str = s.toCharArray();
        boolean[] visited = new boolean[str.length];

        for (int i = 0; i < str.length; i++) {
            if (visited[i]) continue; // already checked

            int cnt = 1; // count current char

            for (int j = i + 1; j < str.length; j++) {
                if (str[i] == str[j]) {
                    cnt++;
                    visited[j] = true; // mark duplicate
                }
            }

            if (cnt == 1) {
                System.out.println("First non-repeating character: " + str[i]);
                return;
            }
        }

        System.out.println("No non-repeating character found");
    }
}
