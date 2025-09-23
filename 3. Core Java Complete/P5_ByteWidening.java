
public class P5_ByteWidening {
    public static void main(String[] args) {
        byte b = 10;
        short s = b;
      //  char c  = b;
        int i = b;
        long l = b;
        float f = b;
        double d = b;

        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
    }
}
