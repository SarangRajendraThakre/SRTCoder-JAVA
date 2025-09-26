import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a custom Marker object with brand, type, price, and color attributes.
 */
class Marker {
    private String brand;
    private String type;
    private double price;
    private String color;

    public Marker(String brand, String type, double price, String color) {
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Marker{" +
               "brand='" + brand + '\'' +
               ", type='" + type + '\'' +
               ", price=" + price +
               ", color='" + color + '\'' +
               '}';
    }
}

public class MarkerSorter {

    // Define a mapping for color values to establish a custom descending order
    // Higher value means higher in the descending sort order.
    private static final Map<String, Integer> COLOR_ORDER = new HashMap<>();

    static {
        COLOR_ORDER.put("red", 5);
        COLOR_ORDER.put("orange", 4);
        COLOR_ORDER.put("black", 3);
        COLOR_ORDER.put("blue", 2);
        COLOR_ORDER.put("green", 1);
        // Assign a default low value for any colors not explicitly listed,
        // so they appear after the defined colors in descending order.
        COLOR_ORDER.put("default", 0);
    }

    /**
     * Returns the numerical value for a given color, used for comparison.
     * Colors not explicitly defined in COLOR_ORDER will get a default low value.
     *
     * @param color The color string.
     * @return An integer representing the color's order value.
     */
    private static int getColorValue(String color) {
        // Convert color to lowercase to ensure case-insensitive comparison
        return COLOR_ORDER.getOrDefault(color.toLowerCase(), COLOR_ORDER.get("default"));
    }

    /**
     * Sorts a list of Marker objects in descending order based on their color
     * using the Insertion Sort algorithm.
     * The order of colors is defined by the COLOR_ORDER map.
     *
     * @param markers The ArrayList of Marker objects to be sorted.
     */
    public static void insertionSortDescendingByColor(List<Marker> markers) {
        int n = markers.size();
        for (int i = 1; i < n; i++) {
            Marker key = markers.get(i); // The current element to be inserted
            int j = i - 1;

            // Move elements of markers[0..i-1], that have a color value
            // less than the key's color value, to one position ahead
            // of their current position.
            // This creates space for 'key' to be inserted in descending order.
            while (j >= 0 && getColorValue(markers.get(j).getColor()) < getColorValue(key.getColor())) {
                markers.set(j + 1, markers.get(j));
                j = j - 1;
            }
            // Place the key at its correct position in the sorted part
            markers.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        // Create a list of Marker objects
        List<Marker> markers = new ArrayList<>();
        markers.add(new Marker("Sharpie", "Fine Point", 2.50, "Blue"));
        markers.add(new Marker("Crayola", "Broad Line", 1.75, "Green"));
        markers.add(new Marker("Pilot", "Permanent", 3.00, "Red"));
        markers.add(new Marker("Staedtler", "Lumocolor", 4.20, "Black"));
        markers.add(new Marker("Faber-Castell", "Art Marker", 3.80, "Orange"));
        markers.add(new Marker("Bic", "Whiteboard", 1.90, "Purple")); // An undefined color

        System.out.println("--- Original Markers ---");
        for (Marker marker : markers) {
            System.out.println(marker);
        }
        System.out.println();

        // Sort the markers in descending order by color
        insertionSortDescendingByColor(markers);

        System.out.println("--- Markers Sorted Descending by Color (Insertion Sort) ---");
        for (Marker marker : markers) {
            System.out.println(marker);
        }
    }
}j