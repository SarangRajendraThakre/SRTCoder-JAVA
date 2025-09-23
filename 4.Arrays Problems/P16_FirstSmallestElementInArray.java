public class P16_FirstSmallestElementInArray {

    public static void main(String[] args) {
        int[] arr = {3,4,4,6,23,4,9};

        int min = Integer.MAX_VALUE;
        
        for(int ele : arr)
        {
            if(min > ele)
            {
                min = ele;
            }
        }
        System.out.println(min);
    }
    
}
