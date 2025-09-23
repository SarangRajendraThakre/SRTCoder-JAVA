
public class P70_Str_StringBuffer_Insert {

    public static void main(String[] args) {
        // Your code here

        StringBuffer sb = new StringBuffer();
        sb.append("sarang");
        System.out.println(sb);
        sb.insert(0, 2.2);
        System.out.println(sb);
        sb.insert(0, 99);
        System.out.println(sb);
        sb.insert(0, "A");
        System.out.println(sb);
        sb.insert(0, true);
        System.out.println(sb);
        sb.insert(0,4l);
        System.out.println(sb);
        sb.insert(0, new char[] {'a','b'});
        System.out.println(sb);
        sb.insert(0,4.4f);
        System.out.println(sb);
        sb.insert(0,"srtcoder");
        System.out.println(sb);
        sb.insert(0,new char[]{'V','S'},1,1);
        System.out.println(sb);
    }
}
