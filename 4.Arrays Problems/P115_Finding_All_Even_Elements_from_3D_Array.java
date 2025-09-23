
public class P115_Finding_All_Even_Elements_from_3D_Array {

    public static void main(String[] args) {
 int[][][] arr = { { { 35, 5, 46, 53, 434 } }, { { 4, 54, 34 } } };

        System.out.println("Printing 3d array using for loop");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    if( arr[i][j][k] % 2 == 0 )
                     System.out.print(arr[i][j][k] + " ");
                }
            }
        }
    }
}
