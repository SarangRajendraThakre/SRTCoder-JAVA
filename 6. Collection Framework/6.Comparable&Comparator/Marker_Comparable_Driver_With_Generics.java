import java.util.*;

// ✅ CORRECT: Using the generic form Comparable<Marker>
class Marker implements Comparable<Marker> {
    String brand;
    String color;
    double price;

    Marker(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String toString() {
        return brand + ", Color : " + color + ", Price : " + price;
    }

    // The method signature changes to accept Marker directly, improving safety.
    @Override // Good practice to include @Override
    public int compareTo(Marker otherMarker) {

        // 1. Primary Sort: Color (Ascending) ⬆️
        int colorComparison = this.color.compareTo(otherMarker.color);

        // If colors are different, return the result immediately.
        if (colorComparison != 0) {
            return colorComparison;
        }

        // 2. Secondary Sort (Tie-Breaker): Price (Descending) ⬇️
        // This is only reached if colorComparison is 0 (colors are the same).
        // Compares otherMarker.price to this.price for DESCENDING sort.
        return Double.compare(otherMarker.price, this.price);
    }
}

public class Marker_Comparable_Driver_With_Generics
 {
    public static void main(String[] args) {
        ArrayList<Marker> list = new ArrayList<>();
        list.add(new Marker("Camlin", "RED", 25));
        list.add(new Marker("Camlin", "BLUE", 45));
        list.add(new Marker("Camlin", "GREEN", 75));
        list.add(new Marker("Camlin", "RED", 15)); // Duplicates 'RED' for tie-breaker test

        System.out.println("--- Initial List ---");
        list.stream().forEach(ele -> System.out.println(ele));

        // Sorting by natural order defined in Marker.compareTo
        // list.sort(null); 
          Collections.sort(list);

        
        System.out.println("----------------------------------------");
        // Note: The comment should reflect the actual sort logic (Color ASC, Price DESC)
        System.out.println("--- Sorted List (Color ASC, Price DESC) ---");

        list.stream().forEach(ele -> System.out.println(ele));
    }
}