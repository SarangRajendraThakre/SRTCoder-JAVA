

class Parent {
    public static void m1() {
        System.out.println("Parent's static m1()");
    }
}

class Child extends Parent {
    // This static method OVERLOADS the one in Parent
    public static void m1(int a) {
        System.out.println("Child's static m1(int a)");
    }
}

public class P47_Overloading_With_Static_Methods_By_Class {
    public static void main(String[] args) {
        // You can call the inherited method via the Child class
        Child.m1(); // Output: Parent's static m1()

        // You can call the method defined in the Child class
        Child.m1(10); // Output: Child's static m1(int a)
    }
}