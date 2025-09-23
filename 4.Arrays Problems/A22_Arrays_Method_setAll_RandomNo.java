
import java.util.Arrays;
import java.util.Random;

public class A22_Arrays_Method_setAll_RandomNo {
    public static void main(String[] args) {
        int[] randomScores = new int[5];
        Random random = new Random();

        // The generator function ignores the index 'i' and simply
        // calls the random number generator for each element.
        Arrays.setAll(randomScores, i -> random.nextInt(100)); // Generates a number from 0-99

        System.out.println("Array of random scores:");
        System.out.println(Arrays.toString(randomScores));
    }
}