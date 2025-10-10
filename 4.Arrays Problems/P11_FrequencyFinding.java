public class P11_FrequencyFinding {

    public static void main(String[] args) {

        int[] arr = { 2, 3, 45, 4, 6, 43, 3, 23, 232, 3, 656, 534, 343, 3 };
        boolean[] v = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (v[i]) // Skip if already counted
                continue;

            int cnt = 1;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    v[j] = true; // mark duplicate as visited
                    cnt++;
                }
            }

            System.out.println(arr[i] + " : " + cnt);
        }
    }
}
