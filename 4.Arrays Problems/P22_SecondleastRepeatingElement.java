import java.util.Arrays;

public class P22_SecondleastRepeatingElement {

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 5, 6, 7, 5434, 6, 5, 5, 2, 2 };

        findSecondLeastRepeatingElement(arr1);

    }

    public static void findSecondLeastRepeatingElement(int[] arr) {
        System.out.println("Original Array: " + Arrays.toString(arr));

        boolean[] visited = new boolean[arr.length];

        int firstHighestFreq = 0;
        int secondHighestFreq = 0;

        int temp1 = 0;
        int temp2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            int currentElement = arr[i];
            int currentCount = 1;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == currentElement && !visited[j]) {
                    currentCount++;
                    visited[j] = true;
                }
            }

            if (currentCount > 1) {
                if (currentCount > firstHighestFreq) {
                    secondHighestFreq = firstHighestFreq;
                    temp1 = arr[i];
                    firstHighestFreq = currentCount;
                } else if (currentCount > secondHighestFreq && currentCount < firstHighestFreq) {
                    secondHighestFreq = currentCount;
                    temp2 = arr[i];
                }
            }
        }

        System.out.println("Element is " + temp1 + " First highest frequency found: " + firstHighestFreq);
        System.out.println("Element is " + temp2 + " Second highest frequency found: " + secondHighestFreq);

    }

}