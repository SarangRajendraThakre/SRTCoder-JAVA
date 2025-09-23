public class RecursiveSelectionSort {

    public static void selectionSortRecursive(int[] arr, int index) {
   
     

        if(index >= arr.length - 1)
        {
            return;
        }

        int minIdx = index;
        for(int i = index +1 ;i<arr.length ;i++)
        {
            if(arr[i] < arr[minIdx])
            {
                minIdx =  i;
            }
        }

      
        if (minIdx != index) { 
            int temp = arr[index];
            arr[index] = arr[minIdx];
            arr[minIdx] = temp;
        }

        selectionSortRecursive(arr, index + 1);
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] myList = {64, 25, 12, 22, 11};
        System.out.print("Original list: ");
        printArray(myList);

        selectionSortRecursive(myList, 0); // Start sorting from index 0
        System.out.print("Sorted list: ");
        printArray(myList);

        System.out.println(); // Add a newline for better separation

     
    }
}