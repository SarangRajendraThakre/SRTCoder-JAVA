
public class MyArrayListDriver {
    public static void main(String[] args) {

        System.out.println("--- Demonstrating Programming to an Interface ---");

        // Use the interface type for the variable declaration
        MyList<String> fruits = new MyArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("List: " + fruits);
        System.out.println("Size: " + fruits.size());

        // ---
        
        MyCollection<String> moreFruits = new MyArrayList<>();
        moreFruits.add("Grape");
        moreFruits.add("Kiwi");
        
        fruits.addAll(1, moreFruits);
        System.out.println("\nAfter addAll: " + fruits);
        
        System.out.println("Does list contain all from moreFruits? " + fruits.containsAll(moreFruits));

        // ---
        
        MyList<String> sub = fruits.subList(2, 5);
        System.out.println("Sublist from index 2 to 5: " + sub);
    }
}
