import java.util.ArrayList;
import java.util.*;

class Product implements Comparable<Product> {
    String name;
    int quantity;
    double price;

    Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" + name + ", Qty: " + quantity + ", Price: $" + price + "}";
    }

    /**
     * NOTE: ONLY ONE compareTo method can be uncommented at a time.
     * The three examples below show how to sort by each property type.
     */

    // ------------------------------------------------------------------
    // ⬇️ Implementation 1: Sort by Price (double) - ASCENDING
    // ------------------------------------------------------------------
    /*
    @Override
    public int compareTo(Product other) {
        // Use Double.compare(this, other) for ascending order (cheapest first).
        System.out.println("Sorting by Price (ASC)");
        return Double.compare(this.price, other.price);
    }
    */

    // ------------------------------------------------------------------
    // ⬇️ Implementation 2: Sort by Name (String) - DESCENDING
    // ------------------------------------------------------------------
 
    @Override
    public int compareTo(Product other) {
        // Use other.name.compareTo(this.name) for descending order (Z-A).
        System.out.println("Sorting by Name (DESC)");
        return other.name.compareTo(this.name);
    }
   

    // ------------------------------------------------------------------
    // ✅ Implementation 3: Multi-Level Sort - Name (ASC) then Quantity (DESC)
    // ------------------------------------------------------------------
    // @Override
    // public int compareTo(Product other) {
    //     // 1. Primary Sort: Name (String) - ASCENDING
    //     int nameComparison = this.name.compareTo(other.name);

    //     if (nameComparison != 0) {
    //         return nameComparison;
    //     }

    //     // 2. Secondary Sort (Tie-Breaker): Quantity (int) - DESCENDING
    //     // Use (other - this) for descending order (highest quantity first).
    //     System.out.println("Sorting by Name (ASC) then Qty (DESC)");
    //     return other.quantity - this.quantity;
    // }
}

public class Comparable_MultiProperty_Example {
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        
        // Data is designed to test the multi-level sort (Implementation 3)
        list.add(new Product("Apple", 10, 2.50));
        list.add(new Product("Banana", 30, 0.50));
        list.add(new Product("Apple", 50, 1.99)); // Same name, different quantity/price
        list.add(new Product("Cherry", 20, 5.99));

        System.out.println("--- Initial List ---");
        list.forEach(System.out::println);

        // Sorts using the ONE uncommented compareTo method (Implementation 3)
        list.sort(null); 
        
        System.out.println("\n----------------------------------------");
        System.out.println("--- Sorted List (Name ASC, Qty DESC) ---");
        list.forEach(System.out::println);
    }
}