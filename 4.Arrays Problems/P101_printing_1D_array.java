
public class P101_printing_1D_array {

    public static void main(String[] args) {

        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };

        // using for loop
        System.out.println("using for loop");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // using while-loop
        System.out.println();
        System.out.println("using while loop");
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }

        // using do while-loop
        System.out.println();
        System.out.println("using  do while loop");
        int ii = 0;

        do {
            System.out.print(arr[ii] + " ");
            ii++;
        } while (ii < arr.length - 1);

        // using for each loop
        System.out.println();
        System.out.println("using for each loop");

        for (int ele : arr)
            System.out.print(ele + " ");

    }
}
