package TypeCasting;

public class P5_IntWidening {
    public static void main(String[] args) {
        int i = 30;
        long l = i;
        float f = i;
        double d = i;

        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
    }
}
