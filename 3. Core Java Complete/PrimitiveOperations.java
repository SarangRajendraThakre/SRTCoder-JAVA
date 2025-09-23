public class PrimitiveOperations {

    public static void main(String[] args) {

        System.out.println("--- Addition (+) Operations ---");
        // byte + byte -> int
        byte b1 = 10;
        byte b2 = 2;
        int result_b_b = b1 + b2; // Result is int due to type promotion
        System.out.println(b1 + " (byte) + " + b2 + " (byte) = " + result_b_b + " (int)");

        // short + short -> int
        short s1 = 200;
        short s2 = 50;
        int result_s_s = s1 + s2; // Result is int due to type promotion
        System.out.println(s1 + " (short) + " + s2 + " (short) = " + result_s_s + " (int)");

        // char + char -> int
        char c1 = 'a'; // ASCII 97
        char c2 = 'b'; // ASCII 98
        int result_c_c = c1 + c2; // Result is int due to type promotion
        System.out.println("'" + c1 + "' (char) + '" + c2 + "' (char) = " + result_c_c + " (int)");

        // int + int -> int
        int i1 = 2147483647;
        int i2 = -2147483647;
        int result_i_i = i1 - i2;
        System.out.println(i1 + " (int) + " + i2 + " (int) = " + result_i_i + " (int)");

        // long + int -> long
        long l1 = 10000L;
        int i3 = 20000;
        long result_l_i = l1 + i3; // int promoted to long
        System.out.println(l1 + " (long) + " + i3 + " (int) = " + result_l_i + " (long)");

        // float + float -> float
        float f1 = 1.1f;
        float f2 = 2.2f;
        float result_f_f = f1 + f2;
        System.out.println(f1 + " (float) + " + f2 + " (float) = " + result_f_f + " (float)");

        // double + double -> double
        double d1 = 1.1;
        double d2 = 2.2;
        double result_d_d = d1 + d2;
        System.out.println(d1 + " (double) + " + d2 + " (double) = " + result_d_d + " (double)");

        // String + String -> String (concatenation)
        String str1 = "SRT";
        String str2 = "Coder";
        String result_str_str = str1 + str2;
        System.out.println("\"" + str1 + "\" (String) + \"" + str2 + "\" (String) = \"" + result_str_str + "\" (String)");

        // int + String -> String (concatenation)
        int num = 123;
        String text = "Data";
        String result_num_str = num + text;
        System.out.println(num + " (int) + \"" + text + "\" (String) = \"" + result_num_str + "\" (String)");

        // Boolean + String -> String (concatenation)
        boolean boolVal = true;
        String boolStrResult = boolVal + text;
        System.out.println(boolVal + " (boolean) + \"" + text + "\" (String) = \"" + boolStrResult + "\" (String)");


        System.out.println("\n--- Subtraction (-) Operations ---");
        // byte - byte -> int
        System.out.println(b1 + " (byte) - " + b2 + " (byte) = " + (b1 - b2) + " (int)");

        // char - char -> int ('a' - 'c')
        char c3 = 'c'; // ASCII 99
        System.out.println("'" + c1 + "' (char) - '" + c3 + "' (char) = " + (c1 - c3) + " (int)");

        // double - float -> double
        System.out.println(d1 + " (double) - " + f1 + " (float) = " + (d1 - f1) + " (double)");


        System.out.println("\n--- Multiplication (*) Operations ---");
        // int * byte -> int
        System.out.println(i1 + " (int) * " + b1 + " (byte) = " + (i1 * b1) + " (int)");

        // float * long -> float
        System.out.println(f1 + " (float) * " + l1 + " (long) = " + (f1 * l1) + " (float)");


        System.out.println("\n--- Division (/) Operations ---");
        // int / int (integer division)
        System.out.println(i1 + " (int) / " + i2 + " (int) = " + (i1 / i2) + " (int)");

        // double / int -> double
        System.out.println(d1 + " (double) / " + i2 + " (int) = " + (d1 / i2) + " (double)");


        System.out.println("\n--- Modulus (%) Operations ---");
        // int % int
        System.out.println(i1 + " (int) % " + i2 + " (int) = " + (i1 % i2) + " (int)");

        // float % float
        System.out.println(f1 + " (float) % " + f2 + " (float) = " + (f1 % f2) + " (float)");


        System.out.println("\n--- Demonstrating Compile Time Errors (Uncomment to see) ---");
        /*
        // boolean + int -> CTE
        boolean flag = true;
        int num2 = 5;
        // int error1 = flag + num2; // This line would cause a Compile Time Error

        // String - int -> CTE
        String str3 = "Test";
        // String error2 = str3 - num2; // This line would cause a Compile Time Error

        // int * boolean -> CTE
        // int error3 = num2 * flag; // This line would cause a Compile Time Error
        */
        System.out.println("Arithmetic operations with boolean or (non-plus) String operands will cause Compile Time Errors.");
    }
}