class Human {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Default Constructor
    public Human() {
        this("sarang", 24); // Calls the parameterized constructor
    }

    // Constructor with only age
    public Human(int age) {
        this("Unknown", age); // Calls the (String, int) constructor
    }

    // Constructor with name and age
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ConstructorOverloading {
    public static void main(String args[]) {
        Human obj1 = new Human("sarang thakre", 24);

        Human obj = new Human(27);
        System.out.println(obj.getAge());

        System.out.println(obj1.getName() + " " + obj1.getAge());
    }
}
