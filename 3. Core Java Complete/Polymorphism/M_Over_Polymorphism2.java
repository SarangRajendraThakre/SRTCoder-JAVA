class Parent {
    public static void m1() {
        System.out.println("m1() Parent");
    }
}

class Child extends Parent {
    public static void m1(int a) {
        System.out.println("m1(int a) Child");
    }
}

public class M_Over_Polymorphism2 {
    // M_over for Method - Overloading
    public static void main(String[] args) {
        Child obj = new Child();
        obj.m1();        // Calls Parent.m1()
        obj.m1(10000);   // Calls Child.m1(int)

        Parent obj1 = new Child();
        obj1.m1();        // Calls Parent.m1()
        // obj1.m1(10000);   // Calls Child.m1(int)
    }
}

//Property 2


// Analyzing the main method:

// Child obj = new Child();: Here, the declared type is Child.

// obj.m1();: The compiler looks at the Child class.
//  It doesn't find a static m1() with no arguments in Child, so it looks up the inheritance chain and finds Parent.m1(). 
// This call resolves to Parent.m1().

// obj.m1(10000);: The compiler again looks at the Child class. It finds a static m1(int a) with one integer argument. This call resolves to Child.m1(int a).

// Parent obj1 = new Child();: Here, the declared type is Parent.

// obj1.m1();: The compiler only sees a Parent reference. It looks at the Parent class, finds m1(), and resolves the call to Parent.m1().

// // obj1.m1(10000);: This line is commented out, and if you were to uncomment it, it would result in a compile-time error.
//  The compiler sees the declared type Parent and checks for a m1(int a) method. 
//  Since Parent does not have a method with an integer argument, the compilation fails, even though the actual object is a Child. 
//  This is a clear demonstration that the decision is made at compile-time based on the reference type, not the runtime object type.