
public class P17_FirstHighestRepeatingElement {

    public static void main(String[] args) {

        int[] arr = { 3, 443, 5, 335, 454, 54, 55, 656, 34, 34, 34, 6, 54, 3 };

        int maxCount = Integer.MIN_VALUE;
        Integer maxElement = null;
        boolean[] v = new boolean[arr.length];

        for (int i = 0, cnt = 1; i < arr.length; i++, cnt = 1) {
            if ((v[i]))
                continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && !(v[j])) {
                    cnt++;
                    v[i] = true;
                }

            }
            if (cnt > maxCount) {
                maxCount = cnt;
                maxElement = arr[i];

            }
        }
        System.out.println("The maxiumu repeating element is " + maxElement + " and count is " + maxCount);

    }
}