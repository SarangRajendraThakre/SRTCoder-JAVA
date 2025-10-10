public class A2_ArrayMaxSize {
    public static void main(String[] args) {
        // This is the theoretical maximum size.
        System.out.println("Theoretical maximum array size: " + Integer.MAX_VALUE);

        try {
            // Attempting to create an array near the max limit.
            // This will likely fail with an OutOfMemoryError.
            int[] largeArray = new int[Integer.MAX_VALUE - 1147483620];
        } catch (OutOfMemoryError e) {
            System.out.println("\nCaught an OutOfMemoryError, as expected.");
            // e.printStackTrace();
        }
    }
}