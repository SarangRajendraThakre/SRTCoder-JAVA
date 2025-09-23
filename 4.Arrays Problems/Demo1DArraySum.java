public class Demo1DArraySum {
    public static void main(String[] args) {
        System.out.println("--- Demo 1D Array Sum ---");

        int[] numbers = {10, 20, 30, 40, 50};

        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }

        System.out.println("Array elements: " + java.util.Arrays.toString(numbers));
        System.out.println("The sum of all elements in the 1D array is: " + sum); // Expected: 150
    }
}