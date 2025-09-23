
public class P133_Str_Finding_First_Highest_Repeating__Word_Or_Character_in_String {

    public static void main(String[] args) {
        // Your code here


        String str = "I am srtCoder , you understand srtCoder";

        String[] StringArr = str.split(" ");

        String result = "";

        boolean[] visited = new boolean[StringArr.length];

        int counter = 0 ;
        int maxLength = Integer.MIN_VALUE;
        int  maxValue = -1;

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
           
            if(cnt > maxLength &&  !(StringArr[i].equals(" ")))
            {
                maxLength = cnt;
                maxValue = i;

                
            }
        }

        System.out.println(StringArr[maxValue] +" : "+maxLength);
        




    }
}
