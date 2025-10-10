public class P18_FirstLeastRepeatingElement {

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 1, -3, -3, 4, 2, 5, 6, 7, 7 };

        System.out.println("--- Array 1 ---");
        int[] outPut = findLeastRepeatingElement(arr1);

        System.out.println("The min Count is " + outPut[0] + " and the element is " + outPut[1]);
    }

    public static int[] findLeastRepeatingElement(int[] arr) {
        boolean[] visited = new boolean[arr.length];

        Integer minElement = null;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0, cnt = 1; i < arr.length; i++, cnt = 1) {
            if (visited[i])
                continue; // Skip already counted

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    cnt++;
                    visited[j] = true; // ✅ Corrected
                }
            }

            if (cnt < minCount) {
                minCount = cnt;
                minElement = arr[i];
            }
        }

        return new int[] { minCount, minElement };
    }
}
