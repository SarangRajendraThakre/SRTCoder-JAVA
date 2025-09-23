

// First interface
interface example1 {
    void m1();
}

// Second interface
interface example2 {
    void m2();
}

// A class implementing both interfaces
class Example implements example1, example2 {
    @Override
    public void m1() {
        System.out.println("m1()");
    }

    @Override
    public void m2() {
        System.out.println("m2()");
    }
}

// Main class to run the code
public class P72_Driveexample3 {
    public static void main(String[] args) {
        // Create an object of the class that implements the interfaces
        Example obj = new Example();

        // Call methods from both interfaces
        obj.m1();
        obj.m2();
    }
}