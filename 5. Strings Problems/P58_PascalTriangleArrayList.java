import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P58_PascalTriangleArrayList {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();


        if (numRows <= 0) {
            return triangle;
        }

        // First row is always [1]
        List<Integer> firstRow = new ArrayList<>();
     
        firstRow.add(1);
        triangle.add(firstRow);

        // Generate subsequent rows based on the previous row
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevList  = triangle.get(i-1);
            List<Integer> currectList = new ArrayList<>();

            currectList.add(1);
            for(int j = 1;j<i;j++)
            {
                int sum = prevList.get(j-1) + prevList.get(j);
                currectList.add(sum);
            }
            currectList.add(1);

            triangle.add(currectList);

        }


        return triangle;
    }

  
    // public static void printTriangle(List<List<Integer>> triangle) {
    //     for (List<Integer> row : triangle) {
    //         for (int num : row) {
    //             System.out.print(num + "  ");
    //         }
    //         System.out.println();
    //     }
    // }

    public static void printTriangle(List<List<Integer>> triangle)
    {
        for(List<Integer> row : triangle)
        {
            for( int num : row)
            {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // --- Main part of the program ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for Pascal's Triangle: ");

        try {
            int numRows = scanner.nextInt();
            if (numRows > 0) {
                List<List<Integer>> triangle = generate(numRows);
                printTriangle(triangle);
            } else {
                System.out.println("Please enter a positive number of rows.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
        } finally {
            scanner.close();
        }
    }
}