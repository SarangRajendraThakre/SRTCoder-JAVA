
public class P103_printing_3D_Array {

    public static void main(String[] args) {
        // Your code here

        // int[][][] arr = { { { 35,5,46,53,434} }, { 4,54,34}}; we can't create this
        // array

        int[][][] arr = { { { 35, 5, 46, 53, 434 } }, { { 4, 54, 34 } } };

        System.out.println("Printing 3d array using for loop");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }
            }
        }
    }
}
