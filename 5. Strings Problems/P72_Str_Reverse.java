
public class P72_Str_Reverse {

    public static void main(String[] args) {
        // Your code here

        String str = "Sarang"; // Sarang6ganraS 

        String s = str;

        s += str.length();
        
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        s += sb.toString();

        System.out.println(s);

    }
}
