
public class P146_Best_Time_To_Buy_Stock {

    public static void main(String[] args) {
        // Your code here


        int [] arr ={7, 1, 5, 3, 6, 4};

        int maxProfit = 0;
        int lowestPrice = arr[0];
        for(int i = 1 ;i<arr.length ;i++)
        {
            if( lowestPrice > arr[i] )
            {
                lowestPrice = arr[i];
            }
            if(maxProfit  <  arr[i]  - lowestPrice )
            {
                maxProfit = arr[i] - lowestPrice;
            }

        }
        System.out.println(maxProfit);
    }
}
