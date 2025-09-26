
public class P76_DownCasting_Rules {

    public static void main(String[] args) {

        // Animal myAnimal = new Dog(); // Upcasting (safe)
        // Dog myDog = (Dog) myAnimal; // Downcasting

        // Animal animal1 = new Dog(); // animal1 actually points to a Dog object
        // Dog dog1 = (Dog) animal1; // SUCCESS! The object is a Dog.


        Animal animal2 = new Animal(); // animal2 actually points to an Animal object
        Dog dog2 = (Dog) animal2; // RUNTIME ERROR! Throws ClassCastException
        // An Animal is not a Dog.


        // We have a variable of type Dog
        Dog myDog = new Dog();

        // Let's try to cast it to a Cat
        // Cat myCat = (Cat) myDog; // COMPILE-TIME ERROR!
    }

}

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}