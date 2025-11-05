
public class P135_P_PatternAskedInMocked3 {

    public static void main(String[] args) {
        int rows = 4; // number of rows
        int[][] triangle = new int[rows][rows];
        int num = 1; // starting number

// 1
// 2 7
// 3 6 8
// 4 5 9 10

    for(int col = 0 ;col<rows;col++)
    {
        if(col % 2 == 0)
        {
            for(int row = 0;row<rows -col ;row++)
            {
                triangle[row+col][col]=num++;
            }
        }
        else
        {
             for(int row =rows - col - 1;   row >=0 ;row--)
            {
                triangle[row+col][col]=num++;
            }
        }

    }

        // Print right-angled triangle
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                if (triangle[i][j] != 0)
                    System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
