class Demo3 {
    void test(int a) {
        System.out.println("int version");
    }
    void test(long a) {
        System.out.println("long version");
    }
    void test(float a) {
        System.out.println("float version");
    }
    void test(double a) {
        System.out.println("double version");
    }
}

public class M_Over_Polymorphism43 {
    public static void main(String[] args) {
        Demo3 d = new Demo3();

        byte b = 10;
        short s = 20;
        char c = 'B';

        d.test(b); // byte → int
        d.test(s); // short → int
        d.test(c); // char → int
    }
}


// Property 4

// if an exact Match isn't found , java automatically Promotes the type to the next widest type 
