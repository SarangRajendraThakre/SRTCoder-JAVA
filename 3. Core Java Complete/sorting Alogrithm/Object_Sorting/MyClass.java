package Object_Sorting;

public class MyClass {

    public static void main(String[] args) {
        System.out.println("Inside the main method.");

        if (args.length > 0 && args[0].equals("callAgain")) {
            System.out.println("Main method called again explicitly!");
            System.out.println("this: "+args[0]);
        } else {
            // Explicitly calling the main method
            System.out.println("Calling main method explicitly from within main...");
            String[] newArgs = {"callAgain"}; // Pass some arguments if needed
            MyClass.main(newArgs); // Calling it using the class name
        }
    }
}