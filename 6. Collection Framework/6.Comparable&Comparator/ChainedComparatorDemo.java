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
        return brand + ", " + color + ", $" + price;
    }
}

// -----------------------------------------------------------
// Custom Comparator Definitions (Simple & Reusable)
// -----------------------------------------------------------

// 1. Color Comparator (Ascending - natural order)
class SortColor implements Comparator<Pen> {
    @Override
    public int compare(Pen p1, Pen p2) {
        return p1.color.compareTo(p2.color);
    }
}

// 2. Brand Comparator (Ascending - natural order)
class SortBrand implements Comparator<Pen> {
    @Override
    public int compare(Pen p1, Pen p2) {
        return p1.brand.compareTo(p2.brand);
    }
}

// 3. Price Comparator (Descending - uses static helper)
// Note: This logic can also be written using a Lambda in the main method.
class SortPriceDesc implements Comparator<Pen> {
    @Override
    public int compare(Pen p1, Pen p2) {
        // Swap arguments for descending order
        return Double.compare(p2.price, p1.price);
    }
}


// Driver class
public class ChainedComparatorDemo {
    public static void main(String[] args) {
        
        List<Pen> pens = new ArrayList<>();
        
        // Data is designed to test all three levels of sorting
        pens.add(new Pen("Pilot", "BLUE", 10.0));
        pens.add(new Pen("Reynolds", "RED", 50.0));
        pens.add(new Pen("Pilot", "BLUE", 25.0));    // Same color, same brand, different price
        pens.add(new Pen("Flair", "BLACK", 15.5));
        pens.add(new Pen("Montex", "RED", 15.3));
        pens.add(new Pen("Flair", "BLUE", 15.0));    // Same color, different brand
        pens.add(new Pen("Cello", "RED", 15.3));     // Same price, different brand

        System.out.println("--- Initial List ---");
        pens.forEach(System.out::println);

        // -------------------------------------------------------------------
        // 🔥 CHAINING COMPARATORS (The Modern Java Way)
        // -------------------------------------------------------------------

        // Primary Sort: Color (Ascending)
        Comparator<Pen> primarySort = new SortColor(); 
        
        // Secondary Sort: Brand (Ascending)
        Comparator<Pen> secondarySort = primarySort.thenComparing(new SortBrand()); 
        
        // Final Sort: Price (Descending)
        Comparator<Pen> finalSort = secondarySort.thenComparing(new SortPriceDesc()); 

        // Apply the final chained comparator to the list
        Collections.sort(pens, finalSort);

        System.out.println("\n--- Sorted List (Color ASC -> Brand ASC -> Price DESC) ---");
        pens.forEach(System.out::println);
    }
}