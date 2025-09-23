
public class productofarray1 {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 6, 8, 2 };
        prodarry(arr);

    }

    static void prodarry(int[] arr) {
        int prod = 1;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            prod *= arr[i];

        }

        for (int i = 0; i < size; i++) {
            System.out.print((int) prod * Math.pow(arr[i], -1) + " ");
        }
    }

}
