

public class P31_Str_Unique_Characters_in_String {

    public static void main(String[] args) {

        String str = "java hello java hie hello hello bye ";
        String op ="";
        String []arr= str.split("");

        boolean[] track = new boolean[arr.length];
        for(int i =0, cnt =0;i<arr.length;i++,cnt=0)
        {

            if(track[i] || arr[i].equals(" ") ) continue;

            for(int j = i;j<arr.length ;j++)
            {
                if(arr[i].equals(arr[j]))
                {
                    cnt++;
                    track[j] =true;
                }

            }

            if(cnt == 1) op+=arr[i]+" ";
           

        }
        op=op.trim();
        System.out.println(str);
        System.out.println(op);




    }
}
