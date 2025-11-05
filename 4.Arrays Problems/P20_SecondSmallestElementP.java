import java.util.Arrays;
import java.util.Arrays;
import java.util.OptionalInt;

public class P20_SecondSmallestElementP {

    public static void main(String[] args) {
        int[] arr = { 23, 44, 34, -4, 56, 653, 75, 66, 5, 54, 54, 47, 75, 6, 5, 4, 44, 3, 76, 7756, 567, 87 };

        System.out.println("Array: " + Arrays.toString(arr));

        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int i = 0;i<arr.length;i++)
        {
            if(firstSmallest > arr[i] )
            {
                secondSmallest = firstSmallest;
                firstSmallest = arr[i];
            }
            else if(arr[i] > firstSmallest && secondSmallest > arr[i] )
            {
                secondSmallest = arr[i];
            }
        }
        System.out.println("firstSmallest : "+firstSmallest+ " and "+" second Smallest "+secondSmallest);


        // --- Using Stream API ---
        OptionalInt secondMinStream = Arrays.stream(arr)
                .distinct()             // remove duplicates
                .sorted()               // sort in ascending order
                .skip(1)                // skip the first smallest
                .findFirst();           // get the second smallest

           

        System.out.println("Second Minimum (Stream API): " + secondMinStream.getAsInt());
    }
}
