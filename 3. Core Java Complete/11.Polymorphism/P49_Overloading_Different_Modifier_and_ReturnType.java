

public class  P49_Overloading_Different_Modifier_and_ReturnType {

    // Method 1: public, instance method, returns int
    public int m1(int a) {
        System.out.println("Called: public int m1(int a)");
        return a;
    }

    // Method 2: static, returns double
    public static double m1(int a, int b) {
        System.out.println("Called: public static double m1(int a, int b)");
        return a + b;
    }
    
    // Method 3: synchronized, instance method, returns String
    public synchronized String m1(String s) {
        System.out.println("Called: public synchronized String m1(String s)");
        return s;
    }

    public static void main(String[] args) {
        P49_Overloading_Different_Modifier_and_ReturnType obj = new P49_Overloading_Different_Modifier_and_ReturnType();

        // Calling the first overloaded method
        obj.m1(10);

        // Calling the second overloaded method (statically)
        P49_Overloading_Different_Modifier_and_ReturnType.m1(10, 20);

        // Calling the third overloaded method
        obj.m1("Hello, Wardha!");
    }
}