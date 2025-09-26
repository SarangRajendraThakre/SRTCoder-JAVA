

class Parent {
    public static void m1() {
        System.out.println("Parent's static m1()");
    }
}

class Child extends Parent {
    public static void m1(int a) {
        System.out.println("Child's static m1(int a)");
    }
}

public class P48_Overloading_With_Static_Methods_By_Obj {
    public static void main(String[] args) {
        Child obj = new Child();

        // Call 1: Resolved using the inherited method from Parent
        obj.m1(); // Output: Parent's static m1()

        // Call 2: Resolved using the method in Child
        obj.m1(10); // Output: Child's static m1(int a)
    }
}