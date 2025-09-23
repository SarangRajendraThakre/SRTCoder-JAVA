
public class reverseno {

    static void reverseno(int arr[], int start, int end) {
        int temp;
        while (start < end) {

            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }
    }

    static void printarry(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void main(String[] args) {

        int arr[] = { 3, 4, 52, 53, 53, 45 };
        printarry(arr, 6);
        reverseno(arr, 0, 5);
        System.out.println(" ");
        printarry(arr, 6);

    }
}