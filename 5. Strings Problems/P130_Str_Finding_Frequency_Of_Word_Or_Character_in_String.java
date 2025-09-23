
public class P130_Str_Finding_Frequency_Of_Word_Or_Character_in_String {

    public static void main(String[] args) {
        // Your code here


        String str = "I am srtCoder , you understand srtCoder";

        String[] StringArr = str.split("");

        String result = "";

        boolean[] visited = new boolean[StringArr.length];

        for(int i = 0 , cnt=1 ;i<StringArr.length;i++,cnt=1)
        {
                 if(visited[i]) continue;
            for(int j = i+1 ;j<StringArr.length;j++)
            {
                if( StringArr[i].equals(StringArr[j]) )
                {
                    cnt++;
                    visited[j] = true;
                }

            }
            if(cnt >= 2 && !(StringArr[i].equals(" ")))
            {
                System.out.println(StringArr[i]+" : " +cnt);

            }
        }




    }
}
