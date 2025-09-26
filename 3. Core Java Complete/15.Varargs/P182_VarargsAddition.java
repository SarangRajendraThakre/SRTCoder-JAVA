
import java.util.Arrays;

public class P182_VarargsAddition {

    /**
     * This method accepts a variable number of integer arguments (varargs).
     * It can be called with zero, one, or more integers.
     */
    public static void addition(int... varargs) {
        System.out.println("Method `addition(int... varargs)` called.");
        // Inside the method, 'varargs' is treated as an array of integers (int[]).
        System.out.println("Arguments received: " + Arrays.toString(varargs));
    }

    /**
     * This is an overloaded method that accepts a String and then a
     * variable number of integer arguments.
     * Rule: The varargs parameter must always be the last parameter in a method signature.
     */
    public static void addition(String str, int... varargs) {
        System.out.println("Method `addition(String, int... varargs)` called.");
        // We can use the 'str' parameter and the 'varargs' array.
        System.out.println(str + " " + Arrays.toString(varargs));
    }

    public static void main(String[] args) {
        // --- Calls to the first addition(int... varargs) method ---

        // Call with zero arguments
        addition();

        // Call with one argument
        addition(10);

        // Call with two arguments
        addition(10, 20);

        // Call with three arguments
        addition(10, 20, 30);

        System.out.println("\n------------------------------------\n");

        // --- Call to the second addition(String, int... varargs) method ---
        // Java knows which method to call based on the arguments provided.
        addition("Hello", 10, 20, 30, 40);
    }
}