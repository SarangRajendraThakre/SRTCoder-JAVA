
public class P134_P_PatternAskedInMocked {

    public static void main(String[] args) {
        // Your code here

    // 1
    // 3 2
    // 6 5 4
    // 10 9 8 7
    // 15 14 13 12 11

        int rows = 5;

        // The starting number for the pattern
        int startNumber = 1;

        // Outer loop for the number of rows
        for (int i = 1; i <= rows; i++) {
            // Inner loop for printing the numbers in descending order
            int currentNumber = startNumber + i - 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(currentNumber + " ");
                currentNumber--;
            }

            // Move to the next line after each row
            System.out.println();
            
            // Update the starting number for the next row
            startNumber = startNumber + i;
        }
    }
}

