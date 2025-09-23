public class NumberPatterns {

    public static void main(String[] args) {
        int numRows = 5;

        System.out.println("Right-Angled Triangle:");
        rightTriangle(numRows);
        System.out.println("\nInverted Right-Angled Triangle:");
        invertedRightTriangle(numRows);
        System.out.println("\nRight-Justified Triangle:");
        rightJustifiedTriangle(numRows);
        System.out.println("\nRight-Justified Inverted Triangle:");
        rightJustifiedInvertedTriangle(numRows);
    }

    // Prints the right-angled triangle pattern
    public static void rightTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // Prints the inverted right-angled triangle pattern
    public static void invertedRightTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // Prints the right-justified right-angled triangle pattern
    public static void rightJustifiedTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            // Prints leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Prints numbers
            for (int k = 1; k <= i; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }

    // Prints the right-justified inverted triangle pattern
    public static void rightJustifiedInvertedTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            // Prints leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Prints numbers
            for (int k = 1; k <= i; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }
}