class Demo {

    void show(int a) {
        System.out.println("int version: " + a);
    }

    void show(double a) {
        System.out.println("double version: " + a);
    }
}

public class M_Over_Polymorphism41 {
    public static void main(String[] args) {
        Demo d = new Demo();

        byte b = 10;
        short s = 20;
        char c = 'A';

        d.show(b); // byte → int (promoted)
        d.show(s); // short → int (promoted)
        d.show(c); // char → int (promoted)
        d.show(12.5); // exact match: double
    }
}


// Property 4

// if an exact Match isn't found , java automatically Promotes the type to the next widest type 