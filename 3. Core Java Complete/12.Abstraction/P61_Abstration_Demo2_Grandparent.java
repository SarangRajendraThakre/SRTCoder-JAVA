

// Abstract base class
abstract class Parent {
    public abstract void m1();
}

// Abstract child class that adds a new abstract method
abstract class ChildA extends Parent {
    public abstract void m2();
}

// Concrete child class that implements Parent's abstract method
class ChildB extends Parent {
    @Override
    public void m1() {
        System.out.println("m1 from ChildB");
    }
}

// Concrete grandchild class that implements all inherited abstract methods
class Grandchild extends ChildA {
    @Override
    public void m1() {
        System.out.println("m1 from Grandchild");
    }

    @Override
    public void m2() {
        System.out.println("m2 from Grandchild");
    }
}

// Driver class to execute the code
public class P61_Abstration_Demo2_Grandparent {
    public static void main(String[] args) {
        // 1. A Parent reference holding a ChildB object
        Parent p = new ChildB();
        p.m1(); // This is valid because m1() is defined in the Parent reference type.

        // NOTE: The line below would cause a COMPILE-TIME ERROR.
        // The compiler only knows about methods in the Parent class, and m2() is not one of them.
        // p.m2();

        System.out.println("--------------------");

        // 2. A standard Grandchild object
        Grandchild a = new Grandchild();
        a.m1();
        a.m2();
    }
}