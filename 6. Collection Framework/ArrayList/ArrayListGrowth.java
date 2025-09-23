import java.util.ArrayList;
import java.lang.reflect.Field;

/**
 * This program demonstrates the internal capacity growth of a standard
 * java.util.ArrayList by using reflection to access its private fields.
 */
public class ArrayListGrowth  {

    public static void main(String[] args) throws Exception {
        
        // Create a new ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // Use Reflection to access the private "elementData" field, which holds the internal array.
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true); // Make the private field accessible

        System.out.println("Tracking ArrayList growth from size 1 to 20...");
        System.out.println("----------------------------------------------");

        // Add 20 elements to the list
        for (int i = 1; i <= 20; i++) {
            list.add(i);
            
            // Get the internal array using our reflection Field object
            Object[] elementData = (Object[]) field.get(list);
            
            // Print the current size and the internal array's length (capacity)
            System.out.println("Size: " + list.size() + ", Capacity: " + elementData.length);
        }
    }
}