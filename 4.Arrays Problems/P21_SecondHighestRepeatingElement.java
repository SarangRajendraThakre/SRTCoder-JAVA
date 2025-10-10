
public class P21_SecondHighestRepeatingElement {

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 1, 2, 3, 5, 3, 5, 6, 7, 8, 9, 10, 10, 10, 12 };

        findSecondHighestRepeatingElement(arr1);

    }

    // public static void findSecondHighestRepeatingElement(int[] arr) {
    // System.out.println("Original Array: " + Arrays.toString(arr));

    // boolean[] visited = new boolean[arr.length];

    // int firstHighestFreq = 0;
    // int secondHighestFreq = 0;
    // int temp1 = 0 ;

    // for (int i = 0; i < arr.length; i++) {
    // if (visited[i]) {
    // continue;
    // }

    // int currentElement = arr[i];
    // int currentCount = 1;

    // for (int j = i + 1; j < arr.length; j++) {
    // if (arr[j] == currentElement) {
    // currentCount++;
    // visited[j] = true;
    // }
    // }

    // if (currentCount > 1) {
    // if (currentCount > firstHighestFreq) {
    // secondHighestFreq = firstHighestFreq;
    // firstHighestFreq = currentCount;
    // temp1 = arr[i] ;

    // } else if (currentCount > secondHighestFreq && currentCount <
    // firstHighestFreq) {
    // secondHighestFreq = currentCount;
    // break;

    // }
    // }
    // }

    // System.out.println( temp1 + " First highest frequency found: " +
    // firstHighestFreq);

    // }

    public static void findSecondHighestRepeatingElement(int[] arr) {

        boolean[] visited = new boolean[arr.length];
        int firstHighCount = Integer.MIN_VALUE;
        Integer firstHighEle = null;
        int secondHighCount = Integer.MIN_VALUE;
        Integer secondHighEle = null;

        for (int i = 0, cnt = 1; i < arr.length; i++, cnt = 1) {
            if (visited[i])
                continue;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j] && !visited[j]) {
                    cnt++;
                    visited[i] = true;
                }

            }

            if (cnt > firstHighCount) {
                secondHighCount = firstHighCount;
                firstHighCount = cnt;

                secondHighEle = firstHighEle;
                firstHighEle = arr[i];

            } else if (cnt > secondHighCount) {
                secondHighCount = cnt;
                secondHighEle = arr[i];
            }
        }

        System.out.println(firstHighEle + " : " + firstHighCount);
        System.out.println(secondHighEle + " : " + secondHighCount);

    }

}