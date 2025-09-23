import java.util.Arrays;

public class nos {

    public static void move(int arr[]) {
        Arrays.sort(arr);

    }

    public static void main(String[] args) {
        int arr[] = { 34, 55, 4, -54, -43, -3, -7, -6 };
        move(arr);
        for (int e : arr) {
            System.out.println(e);
        }
    }

}
