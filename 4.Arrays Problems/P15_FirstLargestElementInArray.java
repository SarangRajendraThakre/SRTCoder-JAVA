public class P15_FirstLargestElementInArray {

    public static void main(String[] args) {
        int[] arr = {3,4,4,6,23,4,9};

        int max = Integer.MIN_VALUE;
        for(int ele : arr)
        {
            if(max < ele)
            {
                max = ele;
            }
        }
        System.out.println(max);
    }
    
}
