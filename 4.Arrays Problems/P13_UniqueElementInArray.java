import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P13_UniqueElementInArray {

    public static void main(String[] args) {

        int[] arr = { 2, 34, 5, 5, 2, 8, 5 };
        uniqueRandomAlphabetsBruteForce(arr);
        uniqueRandomAlphabetsHashMap(arr);

    }

    public static void uniqueRandomAlphabetsBruteForce(int[] arr) {
        boolean[] b = new boolean[arr.length];
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if(b[i]) continue;
            int cnt = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && !b[j]) {
                    cnt++;
                    b[j] = true;
                }
            }
            if (cnt == 1) {
                System.out.println(arr[i] + " : " + cnt);
            }
        }

    }

    public static void uniqueRandomAlphabetsHashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

}
