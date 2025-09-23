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

class Actions {
    public static <T extends Walkable & Talkable> void perform(T creature) {
        creature.walk();
        creature.talk();
    }
}

public class NoClassBoundsExample2 {
    public static void main(String[] args) {
        Person person = new Person();
        Actions.perform(person);
    }
}