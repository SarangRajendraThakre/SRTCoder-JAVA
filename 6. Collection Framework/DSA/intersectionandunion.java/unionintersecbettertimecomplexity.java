import java.util.HashSet;
import java.util.Set;

public class unionintersecbettertimecomplexity {
    public static void getunion(int a[], int b, int c[], int d) {
        int min = (b < d) ? b : d;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < min; i++)

        {
            set.add(a[i]);
            set.add(c[i]);
        }

        if (b > d) {
            for (int i = b; i < d; i++) {
                set.add(a[i]);
            }

        }
        if (d > b)

        {
            for (int i = d; i < b; i++) {
                set.add(c[i]);
            }

        }
        System.out.println("number of element in the union is " + set.size() + "\n");
        System.out.println("element of the union are " + set.toString() + " ");

    }

    public static void main(String[] args) {
        int a[] = { 45, 3, 6, 4, 3, 63, 37, 74, 64, 53, 3, 4, 54, 4, };
        int c[] = { 443, 34, 443, 675, 3, 46, 34, 64, 3, 233, 543, 3, 343, 43, 432234, 54, 43, 65, 54 };

        int b = a.length;
        int d = c.length;
        getunion(a, b, c, d);

    }

}
