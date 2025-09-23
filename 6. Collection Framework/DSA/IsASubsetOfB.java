package String;

import java.util.*;

public class IsASubsetOfB {
    public static String isSubset(int[] a1, int[] a2) {
        Set<Integer> set = new HashSet<>();
        
        // Store all elements of a1 in the set
        for (int num : a1) {
            set.add(num);
        }

        // Check if all elements of a2 exist in the set
        for (int num : a2) {
            if (!set.contains(num)) {
                return "No";
            }
        }

        return "Yes";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read array a1
        System.out.println("Enter the length of first array");
        int n = sc.nextInt();
        System.out.println("Enter the Element "+n+" of first array");

        int[] a1 = new int[n];
        for (int i = 0; i < n; i++) {
            a1[i] = sc.nextInt();
        }

        // Read array a2
        System.out.println("Enter the length of first array");
        int m = sc.nextInt();
        System.out.println("Enter the Element "+m+" of first array");
        int[] a2 = new int[m];
        for (int i = 0; i < m; i++) {
            a2[i] = sc.nextInt();
        }

        

          System.out.println(  isSubset(a1, a2));

        sc.close();
    }
}
