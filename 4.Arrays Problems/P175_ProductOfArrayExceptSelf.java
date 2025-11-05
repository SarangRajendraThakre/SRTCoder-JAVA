import java.util.Arrays;

public class P175_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        // Your code here

        System.out.println(Arrays.toString(ProductOfArray(new int[] { 2, 4, 5 })));

    }

    public static int[] ProductOfArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = 0; j < arr.length; j++) {

                if (i != j)
                    product *= arr[j];
            }
            result[i] = product;

        }
        return result;

    }

}
