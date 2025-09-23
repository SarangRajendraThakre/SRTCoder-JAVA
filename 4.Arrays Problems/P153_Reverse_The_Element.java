
public class P153_Reverse_The_Element {

    public static void main(String[] args) {
        // Your code here

        int[] arr = {23,7656,45};

        for(int i = 0 ;i<arr.length ;i++)
        {
           arr[i] =  reverseElement(arr[i]);

        }
        System.out.println(java.util.Arrays.toString(arr));
    }
    public static int reverseElement(int no)
    {
        int rev = 0 ;
        
        while (no != 0) {
           rev = rev * 10  + no % 10 ;
           no /= 10 ;
            
        }
        
       
      

        return rev;
    }
}
