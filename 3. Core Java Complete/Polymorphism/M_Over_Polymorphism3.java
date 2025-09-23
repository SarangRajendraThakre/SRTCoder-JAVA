class Parent {

    protected Double m1(String a, String b) {
        return Double.parseDouble(a + b);
    }
}

class Child extends Parent {

    // 1. No parameter, void return, public
    public void m1() {
        System.out.println("Method with void return type");
    }

    // 2. Single int parameter, private, returns int
    private int m1(int a) {
        System.out.println("Method with int return type");
        return a;
    }

    // 3. Two int parameters, default access, returns String
    String m1(int a, int b) {
        System.out.println("Method with String return type");
        return String.valueOf(a + b);
    }

    // 4. Single double parameter, static, returns boolean
    public static boolean m1(double d) {
        System.out.println("Static method with boolean return type");
        return d > 0;
    }

    // 5. Single char parameter, protected final, returns char
    protected final char m1(char ch) {
        System.out.println("Final method with char return type");
        return Character.toUpperCase(ch);
    }

    // 6. Three int parameters, public, returns double
    public double m1(int a, int b, int c) {
        System.out.println("Method with double return type");
        return a + b + c;
    }

    // 7. Single String parameter, private, returns int
    private int m1(String s) {
        System.out.println("Private method with int return type");
        return s.length();
    }

    // 8. Two double parameters, public static, returns double
    public static double m1(double x, double y) {
        System.out.println("Static method with double return type");
        return x * y;
    }

    // 9. Single boolean parameter, default access, returns String
    String m1(boolean flag) {
        System.out.println("Method with boolean parameter returning String");
        return flag ? "TRUE" : "FALSE";
    }

    // 10. Two char parameters, public final, returns String
    public final String m1(char ch1, char ch2) {
        System.out.println("Final method with two char parameters");
        return "" + ch1 + ch2;
    }

    // 11. Four int parameters, static, returns int
    public static int m1(int a, int b, int c, int d) {
        System.out.println("Static method with 4 int parameters");
        return a + b + c + d;
    }
}

public class M_Over_Polymorphism3 {
    public static void main(String[] args) {
        Child obj = new Child();

        obj.m1();                        // void version
        System.out.println(obj.m1(10, 20)); // String version (2 int)
        System.out.println(obj.m1("12", "34")); // Parent's Double version
        System.out.println(Child.m1(12.5));    // static boolean version
        System.out.println(obj.m1('a'));       // final char version
        System.out.println(obj.m1(1, 2, 3));   // double return type
        // private method obj.m1(100) not accessible outside class
        System.out.println(Child.m1(2.0, 3.5)); // static double version
        System.out.println(obj.m1(true));       // boolean param, returns String
        System.out.println(obj.m1('x', 'y'));   // final method with 2 chars
        System.out.println(Child.m1(1,2,3,4));  // static 4 int
    }
}


// Property 3 

// This program shows that as long as the methods signature (name , Parameter) is unique ,
// you can have overloaded methods with Different return types , access MOdifiers , and non-access MOdifiers.