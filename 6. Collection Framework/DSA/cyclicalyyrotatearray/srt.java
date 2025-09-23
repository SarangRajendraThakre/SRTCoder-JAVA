
public class srt {

    static void cyclicallyrotate(int[] arr) {
        int last_el = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];

        }
        arr[0] = last_el;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) {
        int[] a = { 4, 7, -6, 54, -84, -1, 64 };
        cyclicallyrotate(a);
    }

}
