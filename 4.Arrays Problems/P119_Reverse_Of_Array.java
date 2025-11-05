
public class P119_Reverse_Of_Array {

    public static void main(String[] args) {
        // Your code here

        int[] arr = { 45, 6, 76, 6, 67, 23, 2, 56, 78, 79, -67, 756, -8, -56 };

        System.out.println("Reverse of Array using for loop");
        System.out.println(java.util.Arrays.toString(arr));
        // for (int i = arr.length - 1, j = 0; i >= arr.length / 2; i--, j++) {
        //     int temp = arr[j];
        //     arr[j] = arr[i];
        //     arr[i] = temp;

        // }
        for(int i = 0 , j = arr.length-1 ; i < arr.length/2 ;i++ , j-- )
        {
            int temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
        }
        System.out.println(java.util.Arrays.toString(arr));

        System.out.println("Reverse of Array using while loop");
        System.out.println(java.util.Arrays.toString(arr));
        int ii = 0, jj = arr.length - 1;
        while (ii < jj) {
            int temp = arr[jj];
            arr[jj] = arr[ii];
            arr[ii] = temp;

            ii++;
            jj--;

        }
        System.out.println(java.util.Arrays.toString(arr));

        System.out.println("Reverse of Array using for each loop");
        System.out.println(java.util.Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();

        for (int ele : arr) {
            sb.append(ele + " ");

        }
        System.out.println(java.util.Arrays.toString(new String(sb.reverse()).split(" ")));

    }
}
