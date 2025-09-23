
public class P112_Finding_all_Odd_Elements {

    public static void main(String[] args) {
        // Your code here

   int[] arr = { 2,4,34,45,45,4,54,67,86,8676,76,65454,5,656,5,6556,454,54,5,4542342,33,2,4235,452,6,7435,455};
        for(int ele : arr)
        {
            if(ele % 2 != 0)
             System.out.print(ele +" ");
        }
    }
}
