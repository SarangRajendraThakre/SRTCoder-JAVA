

public class P5_ShortWidening {
    public static void main(String[] args) {
        short s = 32677;
        int i = s;
        long l = s;
        float f = s;
        double d = s;

        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
    }
}
