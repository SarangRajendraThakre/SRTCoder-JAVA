


public class P34_Str_Highest_Repeating_Character_In_String {

    public static void main(String[] args) {
        
        String str = "java hello java hie hello hello java bye java";
        String op ="";
        String[] arr = str.split("");
        boolean[] track = new boolean[arr.length];

        int HighestCnt = Integer.MIN_VALUE;
        String highestString = null;


        for(int i =0,cnt=0;i<arr.length;i++,cnt=0)
        {
            if(track[i]) continue;

            for(int j = i;j<arr.length;j++)
            {
                if(arr[i].equals(arr[j]))
                {
                    cnt++;
                    track[j]=true;
                }
               
            }
             if(cnt > HighestCnt)
                {
                    HighestCnt = cnt;
                    highestString = arr[i];


                }
           
        }
        System.out.println(str);
         System.out.println( highestString);

    }
}

