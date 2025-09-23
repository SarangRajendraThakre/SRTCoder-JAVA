import java.util.Scanner;

public class P56_PascalTriangle {

    /**
     * Prints Pascal's Triangle up to a specified number of rows.
     * @param rows The total number of rows to generate.
     */
    public static void printPascalTriangle(int rows) {
        if (rows <= 0) {
            System.out.println("Please enter a positive number of rows.");
            return;
        }

        // Outer loop for iterating through each row
        for (int i = 0; i < rows; i++) {
            // Use 'long' to prevent overflow with larger numbers
            long num = 1;

            // Inner loop for printing the numbers in the current row
            for (int j = 0; j <= i; j++) {
                System.out.print(num + "  ");
                // Formula to calculate the next number in the row:
                // C(i, j+1) = C(i, j) * (i - j) / (j + 1)
                num = num * (i - j) / (j + 1);
            }
            // Move to the next line for the next row
            System.out.println();
        }
    }

    // --- Main part of the program ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for Pascal's Triangle: ");

        try {
            int numRows = scanner.nextInt();
            printPascalTriangle(numRows);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
        } finally {
            scanner.close();
        }
    }
}