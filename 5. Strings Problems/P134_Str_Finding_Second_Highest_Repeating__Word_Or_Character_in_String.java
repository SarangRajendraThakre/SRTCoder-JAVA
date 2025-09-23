
public class P134_Str_Finding_Second_Highest_Repeating__Word_Or_Character_in_String {

    public static void main(String[] args) {
        // Your code here


        String str = "I am srtCoder , you understand I  srtCoder ";

        String[] StringArr = str.split(" ");

        String result = "";

        boolean[] visited = new boolean[StringArr.length];

        
        int firstmax = Integer.MIN_VALUE;
        int firstmaxValue = -1;
        int secondMax =Integer.MIN_VALUE;
        int secondMaxValue = -1;

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

            if( !(StringArr[i].equals(" ") ))
            {
                 if(cnt > firstmax)
            {
                secondMax = firstmax;
                secondMaxValue = firstmaxValue;
                firstmax = cnt;
                firstmaxValue = i;
            }
            else if(cnt > secondMax)
            {
                secondMax = cnt;
                secondMaxValue = i;
            }
            }
           


        }
        System.out.println(StringArr[firstmaxValue]+" : "+firstmax);
        System.out.println(StringArr[secondMaxValue]+" : "+secondMax);
           
          




    }
}
