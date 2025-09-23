
import java.util.Arrays;

public class A24_Arrays_Method_HashCode {
    public static void main(String[] args) {

        int[] arr1 = {10, 20, 30};
        int[] arr2 = {10, 20, 30};

        System.out.println("Are the arrays equal using Arrays.equals()? " + Arrays.equals(arr1, arr2));
        System.out.println("----------------------------------------------");

        // --- Using the incorrect, default hashCode() method ---
        // These will almost certainly be different because arr1 and arr2 are different objects.
        System.out.println("Default hashCode for arr1: " + arr1.hashCode());
        System.out.println("Default hashCode for arr2: " + arr2.hashCode());
        System.out.println();

        // --- Using the correct, content-based Arrays.hashCode() method ---
        // These will be the same because the contents are identical.
        System.out.println("Arrays.hashCode for arr1:  " + Arrays.hashCode(arr1));
        System.out.println("Arrays.hashCode for arr2:  " + Arrays.hashCode(arr2));
    }
}