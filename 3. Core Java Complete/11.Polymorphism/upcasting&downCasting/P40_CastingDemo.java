// File: CastingDemo.java

// =================================================================
// 1. DEFINE THE CLASS HIERARCHY
// These classes are empty. Their only purpose is to create the
// inheritance relationships for the demonstration.
// =================================================================
class Parent {}

class ChildA extends Parent {}
class ChildB extends Parent {}

class GrandchildA extends ChildA {}
class GrandchildB extends ChildA {}

class GrandchildC extends ChildB {}
class GrandchildD extends ChildB {}


// =================================================================
// 2. MAIN CLASS TO DEMONSTRATE CASTING SCENARIOS
// =================================================================
public class P40_CastingDemo {

    public static void main(String[] args) {
        System.out.println("--- Java Casting Scenarios ---");

        // ## Scenario 1: UPCASTING (Generalization) ##
        // A subclass object is assigned to a superclass reference.
        // This is always safe and happens automatically.
        System.out.println("\n## 1. Upcasting ##");
        Parent p1 = new ChildA();
        ChildB c1 = new GrandchildC();
        System.out.println("Upcasting successful. (e.g., Parent p1 = new ChildA();)");



        // ## Scenario 2: SUCCESSFUL DOWNCASTING (Specialization) ##
        // A superclass reference is cast back to its correct subclass type.
        // This requires an explicit cast `(TypeName)`.
        System.out.println("\n## 2. Successful Downcasting ##");
        Parent p2 = new GrandchildA(); // First, upcast an object.
        ChildA c2 = (ChildA) p2;       // Now, downcast. This works because the object IS-A ChildA.
        System.out.println("Downcasting from Parent to ChildA was successful.");



        // ## Scenario 3: RUNTIME ERROR (ClassCastException) ##
        // The code compiles, but fails when executed because the object is of the wrong type.
        System.out.println("\n## 3. Runtime Error (ClassCastException) ##");
        Parent p3 = new ChildA(); // p3 refers to a ChildA object.
        try {
            // We try to cast an object of type ChildA to the ChildB type.
            // The compiler allows this because p3 *could* hold a ChildB.
            // At runtime, the JVM knows it's a ChildA and throws an exception.
            ChildB c3 = (ChildB) p3;
            System.out.println("This line will never be reached.");
        } catch (ClassCastException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }



        // ## Scenario 4: COMPILE TIME ERROR ##
        // The compiler knows the cast is impossible and prevents the code from compiling.
        System.out.println("\n## 4. Compile Time Error ##");
        // The following line is commented out because it would prevent the program from running.
        // The compiler knows that ChildA and ChildB are unrelated siblings.
        //
        // ChildA someChildA = new ChildA();
        // ChildB someChildB = (ChildB) someChildA; // COMPILE ERROR: Inconvertible types
        System.out.println("Code like 'ChildB b = (ChildB) new ChildA();' causes a compile error.");

        System.out.println("\n--- Demo Complete ---");
    }
}