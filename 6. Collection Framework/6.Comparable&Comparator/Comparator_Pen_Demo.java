import java.util.*;

// Class containing the data structure (fields, constructor, toString)
class Pen {
    String brand;
    String color;
    double price;

    Pen(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return brand + " " + color + " " + price;
    }
}

// -----------------------------------------------------------
// All Comparator classes are now declared as TOP-LEVEL classes
// -----------------------------------------------------------

// 1. Price Descending (Highest to Lowest)
class SortDescPrice implements Comparator<Pen> {
    @Override
    public int compare(Pen obj1, Pen obj2) {
        // Simple comparison for descending double: obj2 vs obj1
        return Double.compare(obj2.price, obj1.price);
    }
}

// 2. Price Ascending (Lowest to Highest)
class SortAscPrice implements Comparator<Pen> {
    @Override
    public int compare(Pen obj1, Pen obj2) {
        // Simple comparison for ascending double: obj1 vs obj2
        return Double.compare(obj1.price, obj2.price);
    }
}

// 3. Color Descending (Z-A)
class SortColorDesc implements Comparator<Pen> {
    @Override
    public int compare(Pen obj1, Pen obj2) {
        // Swap arguments for descending String order
        return obj2.color.compareTo(obj1.color);
    }
}

// 4. Multi-Level Sort: Color (ASC) then Price (DESC)
class SortColorThenPrice implements Comparator<Pen> {
    @Override
    public int compare(Pen obj1, Pen obj2) {

        // 1. Primary Sort: Color (Ascending) ⬆️
        int colorComparison = obj1.color.compareTo(obj2.color);

        if (colorComparison != 0) {
            return colorComparison; // Colors are different, return the color order
        }

        // 2. Secondary Sort (Tie-Breaker): Price (Descending) ⬇️
        // Colors are the same, compare prices descending.
        return Double.compare(obj2.price, obj1.price);
    }
}

// Driver class to execute the code
public class Comparator_Pen_Demo {
    public static void main(String[] args) {

        List<Pen> list = new ArrayList<>();

        // Add Pen objects to the list (Note: I changed 'set' to 'list' for clarity)
        list.add(new Pen("Cello", "BLUE", 10.0));
        list.add(new Pen("Reynolds", "BLUE", 50.0));
        list.add(new Pen("Flair", "BLACK", 15.5));
        list.add(new Pen("Montex", "RED", 15.3));
        list.add(new Pen("USE&THROW", "RED", 3.0)); // Added a duplicate color to test tie-breaker

        System.out.println("--- Initial original list ---");
        for (Pen pen : list) {
            System.out.println(pen);
        }

        // Apply the multi-level sort: Color (ASC) then Price (DESC)
        Collections.sort(list, new SortColorThenPrice());

        System.out.println("\n--- After applying SortColorThenPrice (Color ASC, Price DESC) ---");
        for (Pen pen : list) {
            System.out.println(pen);
        }

        System.out.println();
        list.stream().forEach(System.out::println);
    }
}