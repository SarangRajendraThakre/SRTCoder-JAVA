import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P30_CommonElementBetweenTwoArrays {

    public static void main(String[] args) {

        int[] arr1 = { 24, 67, 5, 44, 78, 9, 54, 434, 3 };

        int[] arr2 = { 45, 67, 6545, 3, 45, 7, 5, 56, 754, 43, 4 };

        int[] arraysOfduplicate = new int[arr1.length + arr2.length];

        ArrayList<Integer> result = new ArrayList<>();

        int k = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    arraysOfduplicate[k++] = arr1[i];
                    result.add(arr1[i]);
                }
            }
        }

        
        System.out.println(Arrays.toString(arraysOfduplicate));

        System.out.println(result);

        usingTheStreamApi(arr1, arr2);

    }

    public static void usingTheStreamApi(int[] arr1, int[] arr2) {
        List<Integer> result = Arrays.stream(arr1)
                .filter(number -> Arrays.stream(arr2).anyMatch(arr2number -> arr2number == number))
                .boxed().collect(Collectors.toList());

        System.out.println(result);
    }
}
