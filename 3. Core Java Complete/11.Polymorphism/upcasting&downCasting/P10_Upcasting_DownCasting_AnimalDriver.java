
// Superclass
class Animal {
    public void eats() {
        System.out.println("Animal eats");
    }

    public void sleeps() {
        System.out.println("Animal sleeps");
    }
}

// Subclass 1
class Dog extends Animal {
    public void barks() {
        System.out.println("Barking");
    }
}

// Subclass 2
class Cat extends Animal {
    public void meows() {
        System.out.println("Meowing");
    }
}

// Driver class to run the code
public class P10_Upcasting_DownCasting_AnimalDriver {
    public static void main(String[] args) {
        // Creating a Cat object (Specialization)
        Cat obj = new Cat();
        obj.eats(); // Inherited from Animal
        obj.sleeps(); // Inherited from Animal
        obj.meows(); // Specific to Cat
        // obj.bark(); // This was the ERROR, as Cat cannot bark.

        System.out.println("----------");

        // Upcasting (Generalization)
        Animal obj1 = new Dog();
        obj1.eats(); // OK, method is in Animal
        obj1.sleeps(); // OK, method is in Animal
        // obj1.barks(); // This would be a compile error.

        // Downcasting (Specialization)
        Dog obj2 = (Dog) obj1; // Casting obj1 back to a Dog type
        obj2.barks(); // OK, obj2 is a Dog reference
    }
}