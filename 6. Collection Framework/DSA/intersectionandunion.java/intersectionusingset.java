import java.util.HashSet;

public class intersectionusingset {

    public static void getunionn(int e[], int n, int d[], int m) {
        HashSet<Integer> s = new HashSet<>();
        for (int i = 1; i < n; i++) {
            s.add(e[i]);
        }

        for (int i = 1; i < n; i++) {
            s.add(d[i]);

        }
        System.out.println("number of element in union are :" + s.size() + "\n");
        System.out.println("element of union are :" + s.toString() + " ");

    }

    public static void main(String[] args) {
        int e[] = { 45, 3, 6, 3, 7, 4, 86, 65, 434, 4324, 554, 8, 7, 4, 3, 3, 3, 4563, 45, 4, };
        int d[] = { 4, 45, 3, 5, 64, 34, 6, 86, 45, 34, 64, 43, 3, 64, 75, 43, 346, 745, 34, 4, 467, 3, 3 };
        int size1 = e.length;
        int size2 = d.length;

        getunionn(e, size1, d, size2);

    }
}