
public class P72_Str_Reverse_Length_ {

    public static void main(String[] args) {
        // Your code here

        String str = "Sarang"; // Sarang6ganraS 

        String s = str;

        s += str.length();
        
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
       
        // s += sb.toString();

        System.out.println(sb);



        System.out.println( reverse(str));

    }

    public static String reverse(String str)
    {
        String s = "";
        for(int i =str.length()-1;i>=0 ;i--)
        {
            s+= str.charAt(i);
        }
        return s;
        
    }
}
