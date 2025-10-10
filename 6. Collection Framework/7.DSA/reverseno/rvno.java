
public class rvno {
    static void arrayreverse(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void printarry(int arr[], int end) {
        for (int i = 0; i < end; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 343, 43, 54, 2, 3, 3223 };
        printarry(arr, 6);
        arrayreverse(arr, 0, 5);
        printarry(arr, 6);

    }
}
