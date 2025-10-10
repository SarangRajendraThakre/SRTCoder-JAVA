public class P173_AutoUnboxingExample {
    public static void main(String[] args) {
        // Wrapper objects
        Integer numObj = 10;
        Double doubleObj = 20.5;
        Boolean boolObj = true;

        // Auto-unboxing happens here
        int num = numObj;           // Integer → int
        double d = doubleObj;       // Double → double
        boolean b = boolObj;        // Boolean → boolean

        // Using them in expressions
        int sum = num + 5;          // numObj automatically unboxed
        double product = d * 2;     // doubleObj automatically unboxed
        if (b) {                    // boolObj automatically unboxed
            System.out.println("Boolean is true");
        }

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }
}
