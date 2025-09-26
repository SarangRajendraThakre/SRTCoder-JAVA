
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class P105_AllRuntimeExceptionDemos {

    public static void main(String[] args) {
        System.out.println("--- Demonstrating Various Runtime Exceptions ---");

        // An array to hold all our demonstration methods
        Runnable[] demos = {
            P105_AllRuntimeExceptionDemos::causeNullPointerException,
            P105_AllRuntimeExceptionDemos::causeArrayIndexOutOfBoundsException,
            P105_AllRuntimeExceptionDemos::causeStringIndexOutOfBoundsException,
            P105_AllRuntimeExceptionDemos::causeClassCastException,
            P105_AllRuntimeExceptionDemos::causeIllegalArgumentException,
            P105_AllRuntimeExceptionDemos::causeNumberFormatException,
            P105_AllRuntimeExceptionDemos::causeArithmeticException,
            P105_AllRuntimeExceptionDemos::causeIllegalStateException,
            P105_AllRuntimeExceptionDemos::causeConcurrentModificationException,
            P105_AllRuntimeExceptionDemos::causeNoSuchElementException,
            P105_AllRuntimeExceptionDemos::causeEmptyStackException
        };

        // Loop through and run each demo
        for (Runnable demo : demos) {
            try {
                demo.run();
            } catch (Exception e) {
                System.out.println("\n--- CAUGHT EXCEPTION ---");
                e.printStackTrace(System.out); // Print the error stack trace
                System.out.println("------------------------\n");
            }
        }
    }

    // 1. NullPointerException
    public static void causeNullPointerException() {
        System.out.println("Triggering NullPointerException...");
        String s = null;
        s.length(); // Calling a method on a null reference
    }

    // 2. ArrayIndexOutOfBoundsException
    public static void causeArrayIndexOutOfBoundsException() {
        System.out.println("Triggering ArrayIndexOutOfBoundsException...");
        int[] arr = new int[2];
        arr[2] = 5; // Accessing index 2, but valid indices are 0, 1
    }

    // 3. StringIndexOutOfBoundsException
    public static void causeStringIndexOutOfBoundsException() {
        System.out.println("Triggering StringIndexOutOfBoundsException...");
        String str = "hi";
        str.charAt(2); // Accessing index 2, but valid indices are 0, 1
    }

    // 4. ClassCastException
    public static void causeClassCastException() {
        System.out.println("Triggering ClassCastException...");
        Object obj = "I am a String";
        Integer num = (Integer) obj; // Cannot cast a String to an Integer
    }
    
    // 5. IllegalArgumentException
    public static void causeIllegalArgumentException() {
        System.out.println("Triggering IllegalArgumentException...");
        // Setting a thread's priority outside the valid range (1-10)
        Thread.currentThread().setPriority(11); 
    }

    // 6. NumberFormatException
    public static void causeNumberFormatException() {
        System.out.println("Triggering NumberFormatException...");
        Integer.parseInt("not a number"); // "not a number" cannot be parsed into an int
    }

    // 7. ArithmeticException
    public static void causeArithmeticException() {
        System.out.println("Triggering ArithmeticException...");
        int result = 10 / 0; // Division by zero
    }

    // 8. IllegalStateException
    public static void causeIllegalStateException() {
        System.out.println("Triggering IllegalStateException...");
        List<String> list = new ArrayList<>();
        list.add("one");
        Iterator<String> iter = list.iterator();
        iter.remove(); // Cannot remove before calling next()
    }

    // 9. ConcurrentModificationException
    public static void causeConcurrentModificationException() {
        System.out.println("Triggering ConcurrentModificationException...");
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        for (String s : list) {
            list.remove(0); // Modifying the list while iterating over it
        }
    }

    // 10. NoSuchElementException
    public static void causeNoSuchElementException() {
        System.out.println("Triggering NoSuchElementException...");
        List<String> list = new ArrayList<>();
        Iterator<String> iter = list.iterator();
        iter.next(); // Calling next() on an empty iterator
    }

    // 11. EmptyStackException
    public static void causeEmptyStackException() {
        System.out.println("Triggering EmptyStackException...");
        Stack<String> stack = new Stack<>();
        stack.pop(); // Popping from an empty stack
    }
}