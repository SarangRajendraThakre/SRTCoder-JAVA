// Abstract class defines a "contract" for its children.
// It cannot be instantiated.
abstract class Parent {
    public abstract void m1();
    public abstract void m2();
}

// Concrete class that fulfills the Parent contract.
class ChildA extends Parent {
    @Override
    public void m1() {
        System.out.println("Hello m1 from ChildA");
    }

    @Override
    public void m2() {
        System.out.println("Hello m2 from ChildA");
    }
}

// Another concrete class that also fulfills the Parent contract.
class ChildB extends Parent {
    @Override
    public void m1() {
        System.out.println("This is m1 from ChildB");
    }

    @Override
    public void m2() {
        System.out.println("This is m2 from ChildB");
    }
}

// Driver class to run the example.
public class P60_AbstractionDemo {
    public static void main(String[] args) {
        // You can use a Parent reference to hold a ChildA object.
        Parent myObject1 = new ChildA();
        myObject1.m1(); // Runs the m1() method from ChildA
        myObject1.m2(); // Runs the m2() method from ChildA

        System.out.println("--------------");

        // The same Parent reference can also hold a ChildB object.
        Parent myObject2 = new ChildB();
        myObject2.m1(); // Runs the m1() method from ChildB
        myObject2.m2(); // Runs the m2() method from ChildB

        // NOTE: The following line will cause a compile error because Parent is abstract.
        // Parent p = new Parent(); // ERROR!
    }
}