package TypeCasting;

public class P5_LongWidening {
    public static void main(String[] args) {
        long l = 40L;
        float f = l;
        double d = l;

        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
    }
}
