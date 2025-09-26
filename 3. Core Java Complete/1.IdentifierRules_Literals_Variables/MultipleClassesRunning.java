// MainClass.java

// This is the public class, and its name must match the filename.
public class MultipleClassesRunning {
    public static void main(String[] args) {
        System.out.println("Hello from MainClass!");

        // Create objects of other classes defined in the same file
        HelperClass helper = new HelperClass();
        helper.displayMessage();

        AnotherClass another = new AnotherClass();
        another.printInfo();
    }
}

// This is a non-public class defined in the same file.
// It will compile into its own HelperClass.class file.
class HelperClass {
    public void displayMessage() {
        System.out.println("Hello from HelperClass!");
    }
}

// Another non-public class.
// It will compile into its own AnotherClass.class file.
class AnotherClass {
    public void printInfo() {
        System.out.println("Info from AnotherClass.");
    }
}