
public class P154_Find_the_Palindrome_Element_In_Array {

    public static void main(String[] args) {
        // Your code here

        int[] arr  = {2,4,6,4,7,456,54,55,5665,323};

        for(int i = 0 ;i<arr.length;i++)
        {
            if(isPalindrome(arr[i]))
            {
                System.out.print(arr[i]+" ");
            }
        }
    }
    public static boolean isPalindrome( int no)
    {
        int temp = no ;
        int rev = 0 ;
        while (no != 0 ) {
            rev = rev*10 + no % 10 ;
            no /= 10 ;
        }
        if(temp == rev) return true;
        else return false;


    }
}
