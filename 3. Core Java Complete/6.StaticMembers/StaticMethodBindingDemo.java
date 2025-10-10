
// BindingDemo.java
// This is the main public class, and its name must match the file name.
public class StaticMethodBindingDemo {

    public static void main(String[] args) {
        System.out.println("--- Demonstrating Static Binding (Method Hiding) ---");

        // Calling static methods directly via class names
        Parent.greet(); // Static binding: calls Parent's greet()
        Child.greet();  // Static binding: calls Child's greet()

        // Demonstrating static binding with an object reference
        // 'p' is declared as Parent type, but refers to a Child object.
        // Since 'greet()' is static, the method called is determined by the
        // declared type of 'p' (Parent), not its actual object type (Child).
        Parent p = new Child();

        p.greet(); // Static binding: still calls Parent's greet() because 'p' is declared as Parent type.
                   // This is called "method hiding", not "method overriding".

        Child c = new Child();

        c.greet(); // Static binding: still calls Parent's greet() because 'p' is declared as Parent type.
                   // This is called "method hiding", not "method overriding".

    }
}

// Parent class defined in the same file. It cannot be public if BindingDemo is public.
class Parent {
    static void greet() { System.out.println("Hello from Parent"); }
}

// Child class defined in the same file. It cannot be public if BindingDemo is public.
class Child extends Parent {
    static void greet() { System.out.println("Hello from Child"); }
}