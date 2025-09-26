
public class UnderscoreExample {

    public static void main(String[] args) {

        // This line will cause a compilation error in Java 9 and later
        int _s = 10; // Attempting to use a single underscore as an identifier

        System.out.println("Value of underscore: " + _s);

        // This is perfectly fine (underscore as part of a multi-character identifier)
        int _myVariable = 20;
        System.out.println("Value of _myVariable: " + _myVariable);

        // This is also fine (underscore between characters)
        String my_name = "Alice";
        System.out.println("My name: " + my_name);
    }

    // You cannot use it as a method parameter name either
    // public static void printValue(int _) { // This would also error
    //    System.out.println("Value: " + _);
    // }
}