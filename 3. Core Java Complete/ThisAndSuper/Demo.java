package ThisAndSuper;

class A extends Object // Object class is the parent of all the classes keep in mind

{
    A() {
        super();

        System.out.println("A constructor");
    }

    A(int a) {
        super();

        System.out.println(" inside A ");
    }

}

class B extends A {

    B() {
        super();
        System.out.println("B constructor");
    }

    B(int b) {

        super(3);

        System.out.println("inside B");
    }
}

public class Demo {

    public static void main(String args[]) {
        B obj = new B(5);

    }

}
