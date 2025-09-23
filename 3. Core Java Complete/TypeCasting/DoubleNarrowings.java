package TypeCasting;

public class DoubleNarrowings {

    public static void main(String[] args) {
        

        double d = 4324343536.5;
        float f = (float) d;
        long l = (long) d;
        int i = (int) d;
        char c = (char) d;
        short s = (short) d;
        byte b = (byte) d;


        System.out.println("double : "+d );
        System.out.println("float : "+f );
        System.out.println("long : "+l );
        System.out.println("int : "+i );
        System.out.println("char : "+c );
        System.out.println("short : "+s );
        System.out.println("byte : "+b );



    }
    
}
