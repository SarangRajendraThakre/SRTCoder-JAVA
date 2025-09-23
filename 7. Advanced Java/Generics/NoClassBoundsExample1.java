interface Walkable {
    void walk();
}

interface Talkable {
    void talk();
}

class Person implements Walkable, Talkable {
    public void walk() {
        System.out.println("Person is walking.");
    }

    public void talk() {
        System.out.println("Person is talking.");
    }
}

class Actions<T extends Walkable & Talkable> {
    public void perform(T creature) {
        creature.walk();
        creature.talk();
    }
}

public class NoClassBoundsExample1 {
    public static void main(String[] args) {
        // 1. Create an instance of a class that fits the bounds
        Person person = new Person();

        // 2. Create an instance of the generic Actions class
        Actions<Person> personActions = new Actions<>();

        // 3. Call the perform method on the instance
        personActions.perform(person);
    }
}