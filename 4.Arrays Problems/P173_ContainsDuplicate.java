import java.util.HashSet;

public class P173_ContainsDuplicate {

    public static void main(String[] args) {

        System.out.println(containsDuplicate(new int[] { 3, 5, 6, 434, 3 }));

    }

    public static boolean containsDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;

    }
}


// https://leetcode.com/problems/contains-duplicate/