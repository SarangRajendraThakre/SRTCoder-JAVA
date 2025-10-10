import java.util.Arrays;

public class srt {
    public static int solution(int arr3[]) {
        int x = arr3.length;
        if (x % 2 == 0) // if length is even
        {
            int z = x / 2;
            int e = arr3[z];
            int f = arr3[z - 1];
            int g = (e + f) / 2;
            return g;

        } else {
            return arr3[Math.round(x / 2)];
        }

    }

    public static void main(String[] args) {
        int arr1[] = { 2, 3, 5, 8 };
        int arr2[] = { 10, 12, 14, 16, 18, 20 };

        int i = arr1.length;
        int j = arr2.length;

        int[] arr3 = new int[i + j];
        System.arraycopy(arr1, 0, arr3, 0, i);
        System.arraycopy(arr2, 0, arr3, i, j);
        Arrays.sort(arr3);
        System.out.println("the median of the merged arr is " + solution(arr3));

    }

}
