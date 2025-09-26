class Parent {
    public static void m1() {
        System.out.println("Parent m1()");
    }

}

class Child extends Parent {
    public static void m1() {
        System.out.println("Child m1()");
    }

}

// Method Shadowing is resolved at the compile time
// i.e based on the reference type rather then object type.

public class Method_Shadowing_1 {

    public static void main(String[] args) {

        Parent obj = new Child();
        obj.m1();

    }

}
