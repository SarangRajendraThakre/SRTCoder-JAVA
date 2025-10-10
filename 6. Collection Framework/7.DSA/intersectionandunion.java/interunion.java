import java.util.HashSet;

public class interunion {
    public static void getunion(int a[], int n, int b[], int m) {
        HashSet<Integer> s = new HashSet<>();
        for (int i = 1; i < n; i++) {
            s.add(a[i]);
        }
        for (int i = 1; i < m; i++) {
            s.add(b[i]);
        }
        System.out.println("number of element after union operation : " + s.size() + "\n");
        System.out.println("union array of both array :" + "\n");
        System.out.println(s.toString() + " ");

    }

    public static void main(String[] args) {
        int a[] = { 5, 3, 6, 3, 74, 43, 64, 3 };
        int b[] = { 4, 6, 34, 3, 3, 36, 74, 7, 6 };
        int size1 = a.length;
        int size2 = b.length;

        getunion(a, size1, b, size2);
    }

}
