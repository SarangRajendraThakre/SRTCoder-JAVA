
public class P52_Method_Shadowing {

    public static void main(String[] args) {

        Parent child = new Child();

        child.m1();
        
        Child.m1();
        Parent.m1();
    }
}

class Parent {
     static void m1() {
        System.out.println("Parent's static m1()");
    }
}

class Child extends Parent {
    // This is valid because 'protected' is the same access level.
    // 'public' would also be valid.
    public static void m1() {
        System.out.println("Child's static m1()");
    }
}