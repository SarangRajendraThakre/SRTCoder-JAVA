
public class P132_finding_The_Smallest_Word{

    public static void main(String[] args) {
        // Your code here


        String str = "I am srtCoder , you understand srtCoder";


        String[] arr = str.split(" ");

        int max = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0 ;i<arr.length;i++)
        {
            if(  arr[i].length() < max  )
            {
                index = i;
                max = arr[i].length()  ;
            }
        }
        System.out.println(max+" : "+arr[index]);

    }


}