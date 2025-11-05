
public class P121_Storing_Even_Element {

    public static void main(String[] args) {

        int[] arr = new int[100];

        try {

            for (int i = 0, j = 0;; i++) {
                if (i % 2 != 0) {
                    arr[j] = i;
                    j++;
                }
            }
        } catch (Exception e) {
            return;

        } finally {
            System.out.println(java.util.Arrays.toString(arr));
        }

    }
}
