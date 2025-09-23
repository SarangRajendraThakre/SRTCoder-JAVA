public class P1_ProductOfArray {
    public static void main(String[] args) {
        // Declare and initialize the array
        int[] numbers = {2, 3, 4, 5};

        // Initialize product variable
        int product = 1;

        // Loop through each element and multiply
        for (int num : numbers) {
            product *= num;
        }

        // Output the result
        System.out.println("The product of all elements is: " + product);
    }
}
