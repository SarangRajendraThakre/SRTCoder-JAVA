import java.util.ArrayList;
import java.util.*;

class Marker implements Comparable {
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

    // public int compareTo(Object obj) {
    // Marker otherMarker = (Marker) obj;
    // return Double.compare(this.price, otherMarker.price);
    // }

    // // descending order
    // public int compareTo(Object obj) {
    // Marker otherMarker = (Marker) obj;
    // return otherMarker.color.compareTo(this.color);
    // }

    // // asecnding order
    // public int compareTo(Object obj) {
    //     Marker otherMarker = (Marker) obj;
    //     return this.color.compareTo(otherMarker.color);
    // }


       public int compareTo(Object obj) {
        Marker otherMarker = (Marker) obj;

        // 1. Primary Sort: Color (Ascending) ⬆️
        int colorComparison = this.color.compareTo(otherMarker.color);

        // If colors are different, return the result immediately.
        if (colorComparison != 0) {
            return colorComparison;
        }

        // 2. Secondary Sort (Tie-Breaker): Price (Descending) ⬇️
        // If colors are the same (colorComparison == 0), compare prices.
        // Swap arguments in Double.compare for DESCENDING (most expensive first)
        return Double.compare(otherMarker.price, this.price);
    }


}

public class P1_Marker_Comparable_Driver {
    public static void main(String[] args) {
        ArrayList<Marker> list = new ArrayList<>();
        list.add(new Marker("Camlin", "RED", 25));
        list.add(new Marker("Camlin", "BLUE", 45));
        list.add(new Marker("Camlin", "GREEN", 75));
        list.add(new Marker("Camlin", "RED", 15));

        System.out.println("--- Initial List ---");
        // Print initial list using streams
        list.stream().forEach(ele -> System.out.println(ele));

        // list.sort(null);
        Collections.sort(list);

        System.out.println("----------------------------------------");
        System.out.println("--- Sorted List (Descending by Color) ---");

        // Print the sorted list using streams
        list.stream().forEach(ele -> System.out.println(ele));
    }
}