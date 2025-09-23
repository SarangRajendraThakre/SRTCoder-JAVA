public class A3_ArrayCreationDemo {
    public static void main(String[] args) {
        
        // --- Primitive Types ---
        int[] intArray = new int[3];
        long[] longArray = new long[3];
        double[] doubleArray = new double[3];
        char[] charArray = new char[3];
        boolean[] booleanArray = new boolean[3];
        
        // Assigning a value to the first element
        intArray[0] = 100;
        charArray[0] = 'A';
        
        System.out.println("First int: " + intArray[0]);
        System.out.println("First char: " + charArray[0]);

        // --- Non-Primitive (Object) Type ---
        String[] stringArray = new String[2];
        stringArray[0] = "Hello";
        stringArray[1] = "World";

        System.out.println("First String: " + stringArray[0]);

        // --- Multi-Dimensional Array ---
        int[][] twoDArray = new int[2][2];
        twoDArray[0][1] = 50;

        System.out.println("2D Array element: " + twoDArray[0][1]);
    }
}