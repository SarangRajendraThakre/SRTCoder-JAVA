
public class P109_Sum_Of_3D_Array_Elements {

    public static void main(String[] args) {
    
        int[][][] arr = { { { 35, 5, 46, 53, 434 } }, { { 4, 54, 34 } } };

        int sum = 0 ;

        System.out.println("Printing 3d array using for loop");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    sum += arr[i][j][k];
                }
            }
        }
        System.out.println(sum);
    }
}
