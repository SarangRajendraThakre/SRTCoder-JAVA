import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class A14_ParallelSortPerformance {

    public static void main(String[] args) {
        // Use a large array to see a noticeable performance difference
        int arraySize = 20_000_000;

        int[] arrayForRegularSort = new int[arraySize];
        Random random = new Random();

        System.out.println("Populating array with " + arraySize + " random numbers...");
        for (int i = 0; i < arraySize; i++) {
            arrayForRegularSort[i] = random.nextInt();
        }

        // Create an identical second array for the parallel sort
        int[] arrayForParallelSort = Arrays.copyOf(arrayForRegularSort, arraySize);
        System.out.println("-------------------------------------------------");


        // --- Time the standard Arrays.sort() ---
        System.out.println("Starting standard Arrays.sort()...");
        long startTimeRegular = System.nanoTime();

        Arrays.sort(arrayForRegularSort);

        long endTimeRegular = System.nanoTime();
        long durationRegular = TimeUnit.NANOSECONDS.toMillis(endTimeRegular - startTimeRegular);
        System.out.println("Standard sort took: " + durationRegular + " ms");
        System.out.println("-------------------------------------------------");


        // --- Time Arrays.parallelSort() ---
        System.out.println("Starting Arrays.parallelSort()...");
        long startTimeParallel = System.nanoTime();

        Arrays.parallelSort(arrayForParallelSort);

        long endTimeParallel = System.nanoTime();
        long durationParallel = TimeUnit.NANOSECONDS.toMillis(endTimeParallel - startTimeParallel);
        System.out.println("Parallel sort took: " + durationParallel + " ms 🚀");
        System.out.println("-------------------------------------------------");

        // --- Conclusion ---
        if (durationParallel < durationRegular) {
            System.out.println("Conclusion: parallelSort() was faster on this machine.");
        } else {
            System.out.println("Conclusion: standard sort() was faster on this machine (might happen on single-core CPUs or for smaller arrays).");
        }
    }
}