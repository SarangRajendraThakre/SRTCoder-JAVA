
public class P22_Str_AnagramString {

    public static void main(String[] args) {


        String str1 = "hello";
        String str2 =  "ellho";

        if(isAnagram(str1,str2))
        {
            System.out.println("ANAGRAM");
        }
         else
           System.out.println(" Not Anagram");
    }

    public static boolean isAnagram(String ...str)
    {
        if(str[0].length() != str[1].length()) return false;

        char[] arr1 = str[0].toCharArray();
        char[] arr2 = str[1].toCharArray();

        bubbleSort(arr1);
        bubbleSort(arr2);

        for(int i = 0;i<arr1.length;i++)
        {
            if(arr1[i]!= arr2[i]) return false;
        }
        return true;
    }

    public static void bubbleSort(char [] arr)
    {
        for(int i = 0;i<arr.length - 1; i++)
        {
           boolean isSwapped = false;
            for(int j = 0 ;j<arr.length-i-1 ;j++) 
            {
                if(arr[j] > arr[j+1])
                {
                    char temp = arr[j];
                    arr[j]  = arr[j+1]; 
                    arr[j+1] = temp;
                    isSwapped=true;
                }
            }
            if(!(isSwapped)) return;
        }
    }
   
   
}
