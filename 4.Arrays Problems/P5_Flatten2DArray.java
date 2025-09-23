import java.util.Arrays;

public class P5_Flatten2DArray {

    public static int[] flattenArray(int[][] twoDArray) {

        int totalElements = 0;
        for (int[] ele : twoDArray) {
            if (ele != null) {
                totalElements += ele.length;
            }
        }

        int oneDArray[] = new int[totalElements];

        int index = 0;
        for (int i = 0; i < twoDArray.length; i++) {
            if (twoDArray[i] != null) {
                for (int j = 0; j < twoDArray[i].length; j++) {
                    oneDArray[index++] = twoDArray[i][j];

                }
            }

        }

        return oneDArray;
    }

    public static void main(String[] args) {
        int[][] my2DArray = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[] flatArray = flattenArray(my2DArray);

        System.out.print("Flattened array: [");
        for (int i = 0; i < flatArray.length; i++) {
            System.out.print(flatArray[i]);
            if (i < flatArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int[][] jaggedArray = {
                { 10, 20 },
                { 30, 40, 50 },
                { 60 }
        };
        int[] flatJaggedArray = flattenArray(jaggedArray);

        // Correct way to print the flattened jagged array using Arrays.toString()
        System.out.println("Flattened jagged array: " + Arrays.toString(flatJaggedArray));

    }
}