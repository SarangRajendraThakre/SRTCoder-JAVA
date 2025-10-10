public class UnderscoreDemoAll {

    public static void main(String[] args) {

        System.out.println("--- Valid uses of underscore ---");

        // ✅ Underscore as part of multi-character variable names
        int _s = 10;
        System.out.println("_s = " + _s);

        int _myVariable = 20;
        System.out.println("_myVariable = " + _myVariable);

        String my_name = "Alice";
        System.out.println("my_name = " + my_name);

        int x_ = 30;
        System.out.println("x_ = " + x_);

        int my_var1 = 40;
        System.out.println("my_var1 = " + my_var1);

        // ✅ Underscore in numeric literals
        int million = 1_000_000;
        long creditCard = 1234_5678_9012_3456L;
        double pi = 3.14_15_92;
        System.out.println("million = " + million);
        System.out.println("creditCard = " + creditCard);
        System.out.println("pi = " + pi);

        // ✅ Underscore in method names
        Example_Method();

        System.out.println("\n--- Invalid uses of underscore (commented, will not compile in Java 9+) ---");

        // ❌ Single underscore as variable
        // int _ = 50;

        // ❌ Single underscore as method parameter
        // printValue(_);

        // ❌ Underscore at start or end of numeric literal
        // int invalid1 = _1000;
        // int invalid2 = 1000_;
        // int invalid3 = 0x_FF;
        // int invalid4 = 0b_1010;
        // double invalid5 = 3._1415;
        // double invalid6 = 3_.1415;
        // long invalid7 = 1234_5678_L;
        // float invalid8 = 1.23F_;
    }

    public static void Example_Method() {
        System.out.println("Example_Method() is valid!");
    }

    // ❌ Invalid: single underscore as method parameter
    // public static void printValue(int _) {
    // System.out.println(_);
    // }
}
