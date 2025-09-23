import java.util.Arrays;

public class P33_LargestLuckyNo {

    public int findLucky(int[] arr) {

        int[] freq = new int[501];

        for (int num : arr) {
            freq[num]++;
        }

        for (int i = 500; i >= 1; i--) {

            if (freq[i] == i) {

                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        P33_LargestLuckyNo solver = new P33_LargestLuckyNo();

        int[] arr1 = { 2, 2, 3, 4 };
        int result1 = solver.findLucky(arr1);
        System.out.println("Input: " + Arrays.toString(arr1) + ", Largest Lucky Integer: " + result1);

        int[] arr2 = { 1, 2, 2, 3, 3, 3 };
        int result2 = solver.findLucky(arr2);
        System.out.println("Input: " + Arrays.toString(arr2) + ", Largest Lucky Integer: " + result2);

        int[] arr3 = { 2, 2, 2, 3, 3 };
        int result3 = solver.findLucky(arr3);
        System.out.println("Input: " + Arrays.toString(arr3) + ", Largest Lucky Integer: " + result3);

        int[] arr4 = { 7, 7, 7, 7, 7, 7, 7 };
        int result4 = solver.findLucky(arr4);
        System.out.println("Input: " + Arrays.toString(arr4) + ", Largest Lucky Integer: " + result4);

        int[] arr5 = { 1, 2, 3, 4, 5, 6 };
        int result5 = solver.findLucky(arr5);
        System.out.println("Input: " + Arrays.toString(arr5) + ", Largest Lucky Integer: " + result5);

        int[] arr6 = { 3, 3, 3, 1, 1, 2 };
        int result6 = solver.findLucky(arr6);
        System.out.println("Input: " + Arrays.toString(arr6) + ", Largest Lucky Integer: " + result6);

        int[] arr7 = { 5, 5, 5, 5 };
        int result7 = solver.findLucky(arr7);
        System.out.println("Input: " + Arrays.toString(arr7) + ", Largest Lucky Integer: " + result7);

        int[] arr8 = { 1 };
        int result8 = solver.findLucky(arr8);
        System.out.println("Input: " + Arrays.toString(arr8) + ", Largest Lucky Integer: " + result8);

        int[] arr9 = new int[500];
        Arrays.fill(arr9, 500);
        int result9 = solver.findLucky(arr9);
        System.out.println("Input: " + Arrays.toString(Arrays.copyOfRange(arr9, 0, Math.min(arr9.length, 10)))
                + "... (truncated), Largest Lucky Integer: " + result9);
    }
}
