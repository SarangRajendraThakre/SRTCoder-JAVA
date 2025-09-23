import java.util.ArrayList;
import java.util.LinkedList;

// A simple mutable class from the previous example
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class ArrayListShallowCopy {
    public static void main(String[] args) {
        // 1. Create the original list (a LinkedList)
        LinkedList<User> originalList = new LinkedList<>();
        originalList.add(new User("Charles"));
        originalList.add(new User("Diana"));

        // 2. Create an ArrayList from the LinkedList -> This is a shallow copy.
        ArrayList<User> shallowCopyArrayList = new ArrayList<>(originalList);

        System.out.println("--- Before Change ---");
        System.out.println("Original (LinkedList): " + originalList);
        System.out.println("Copy (ArrayList):    " + shallowCopyArrayList);

        // 3. Get the first user FROM THE NEW ARRAYLIST and modify it.
        User userFromArrayList = shallowCopyArrayList.get(0);
        userFromArrayList.setName("Charles III");

        System.out.println("\n--- After Change ---");
        // 4. The change appears in BOTH lists because they share the same User object.
        System.out.println("Original (LinkedList): " + originalList);
        System.out.println("Copy (ArrayList):    " + shallowCopyArrayList);

        LinkedList<User> list2 = new LinkedList<>(shallowCopyArrayList);
        System.out.println(list2);
        list2.set(1,new User("sarang"));
        System.out.println(list2);
        System.out.println(shallowCopyArrayList);
        
    }
}