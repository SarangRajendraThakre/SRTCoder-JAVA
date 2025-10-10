public class A1ArrayDeclaration {

    public static void main(String[] args) {

        // All are 1D arrays
        int[] arr1;
        int arr2[];
        int[] arr3;

        // 3D array
        int[][] a3D[];

        // All are 1D arrays
        byte[] b1, b2, b3;

        // a is 2D, b is 1D
        short[] a2D[], b1D;

        // Both a and b are 2D
        char[] ca2D[], cb2D[];

        // a is 1D, b is 2D, c is 3D
        boolean[] ba1D, bb2D[], bc3D[][];

        // a is 1D, b and c are simple variables
        long la1D[], lb, lc;

        // THIS IS VALID: a is 2D, b is 1D
        float[] fa2D[], fb1D;

        // a is 2D, b is 3D, c is 4D
        double[][] da2D, db3D[], dc4D[][];

        // syntax error here ↓
        // int[] arr34 , [] arr23;

        System.out.println("All declarations are valid and compiled successfully.");
    }
}