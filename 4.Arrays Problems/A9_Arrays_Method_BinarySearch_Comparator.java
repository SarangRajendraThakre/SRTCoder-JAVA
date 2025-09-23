import java.util.Arrays;
import java.util.Comparator;

// A simple custom class
class Product {
    String name;
    int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ": $" + price;
    }
}


public class A9_Arrays_Method_BinarySearch_Comparator {
    public static void main(String[] args) {
        Product[] products = {
            new Product("Milk", 80),
            new Product("Bread", 120),
            new Product("Butter", 250),
            new Product("Cheese", 400)
        };

        // Here, T becomes the 'Product' type.

        // Define the custom comparison logic using a Comparator.
        // This tells the search to only look at the price.
        Comparator<Product> priceComparator = Comparator.comparingInt(p -> p.price);

        // The array is already sorted by price, so we can search.
        // We are searching for any product with a price of 250.
        // The 'key' can be a dummy object used just for the search.
        Product searchKey = new Product("dummy", 250);

        int index = Arrays.binarySearch(
            products,          // T[] a: The array of Products
            searchKey,         // T key: The Product we're looking for
            priceComparator    // Comparator<? super T> c: The logic for comparison
        );

        if (index >= 0) {
            System.out.println("Found: " + products[index] + " at index " + index);
        } else {
            System.out.println("Product not found.");
        }
        // Output: Found: Butter: $250 at index 2
    }
}