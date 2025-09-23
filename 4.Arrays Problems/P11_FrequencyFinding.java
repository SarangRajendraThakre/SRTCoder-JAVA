
public class P11_FrequencyFinding {

    public static void main(String[] args) {

        int[] arr = {2,3,45,4,6,43,3,23,232,3,656,534,343,3};
        boolean[] v = new boolean[arr.length];

        for(int  i = 0 , cnt=1 ;i<arr.length;i++,cnt=1)
        {
            if(v[i]) continue;
            for(int j = i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j] && !(v[i]))
                {
                    v[i] = true;
                    cnt++;
                }

            }
            if(cnt>0)
            {
                System.out.println(arr[i]+" : "+cnt);
            }
        }

    }}