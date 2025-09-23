
public class P30_Str_Frequency_Of_Characters_In_String {

    public static void main(String[] args) {

        String str = "java hello java hie hello hello bye ";
        String op ="";
        String []arr= str.split("");

        boolean[] track = new boolean[arr.length];
        for(int i =0, cnt =0;i<arr.length;i++,cnt=0)
        {
            if(track[i]) continue;

            for(int j = i;j<arr.length ;j++)
            {
                if(arr[i].equals(arr[j]))
                {
                    cnt++;
                    track[j] =true;
                }

            }
            System.out.println(arr[i]+" : "+cnt);

        }




    }
}
