import java.util.ArrayList;
import java.util.List;

class Animal {
    public void sound() { System.out.println("Animal sound"); }
}
class Dog extends Animal {

    public void sound() { System.out.println("Bark"); }   
    
}
class Cat extends Animal {
    public void sound() { System.out.println("Meow"); }
}

public class WildcardSolution {
    // This method can safely READ from the list
    public static void printSounds(List<? extends Animal> animals) {
        System.out.println("--- Printing Sounds ---");
        for (Animal a : animals) {
            a.sound(); // Safe: We know everything in the list is at least an Animal.
        }
        // animals.add(new Dog()); // COMPILE-TIME ERROR: You cannot add to a '? extends' list.
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());

        // This is now perfectly legal and safe!

        List<? extends Animal> someAnimals = dogs;         
        
        System.out.println("Assigned List<Dog> to List<? extends Animal>");

        // We can safely pass both lists to our flexible method.
        printSounds(dogs);
        printSounds(cats);
    }
}