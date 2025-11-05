public class P177_SearchingInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 3, 4, 5, 6, 7, 8};
        int target = 10;

        int result = searchInRotatedSortedArray(arr, target);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");
    }

    public static int searchInRotatedSortedArray(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 🎯 Found target
            if (arr[mid] == target) return mid;

            // 🔹 Left half is sorted
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 🔹 Right half is sorted
            else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1; // not found
    }
}
