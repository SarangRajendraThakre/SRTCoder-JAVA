import java.util.Arrays;

public class P4_BinarySearchUsingRecursion {

    public static void main(String[] args) {
        int arr[] = new int[10];

        for (int i = 0, j = 10; i < 10; i++, j += 10) {
            arr[i] = j;
        }

        System.out.println(Arrays.toString(arr)); 

        int key1 = 90;
        int pos1 = binarySearch(arr, key1, 0, arr.length - 1); 

        if (pos1 != -1) {
            System.out.println(key1 + " is found at index " + pos1);
        } else {
            System.out.println(key1 + " not found");
        }

        int key2 = 55; // Test with a key not in the array
        int pos2 = binarySearch(arr, key2, 0, arr.length - 1);

        if (pos2 != -1) { 
            System.out.println(key2 + " is found at index " + pos2);
        } else {
            System.out.println(key2 + " not found");
        }
    }

    public static int binarySearch(int[] arr, int key, int min, int max) {
        if (min > max) {
            return -1;
        }

        int mid = min + (max - min) / 2;

        if (key == arr[mid]) {
            return mid;
        } 
        else if (key < arr[mid]) {
            return binarySearch(arr, key, min, mid - 1); 
        } 
        else { 
            return binarySearch(arr, key, mid + 1, max); 
        }
    }
}