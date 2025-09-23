package TypeCasting;

public class P5_CharWidening{
    public static void main(String[] args) {
        char c = 'A';
        int i = c;
        long l = c;
        float f = c;
        double d = c;

        System.out.println("char: " + c);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
    }
}
