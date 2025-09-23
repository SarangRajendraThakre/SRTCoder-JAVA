import java.util.Arrays;

public class P4_BinarySearch1
{ 
    public static void main(String[] args) {

        int arr[] = new int[10];

        for (int i = 0, j = 10; i < 10; i++, j += 10) {
            arr[i] = j;

        }

        System.out.println(Arrays.toString(arr));

        int key = 90;

        int pos = binarySort(arr, key);

        if (pos != -1) {
            System.out.println(key + " is found at " + pos);
        } else {
            System.out.println(key + "not found");
        }

    }

    public static int binarySort (int arr[] , int key)
    {
        int low = 0 ;
        int high = arr.length - 1;

        while(low < high)
        {
            int mid = (low + high)/2;
             if(arr[mid] > key)
             {
                high = mid -1;
             }
             else if(arr[mid] < key)
             {
                low = mid +1;
             }
             else
             {
                 return mid;
             }


        }

        return -1;



    
    }



}




// https://gemini.google.com/app/12f907497b5305a5