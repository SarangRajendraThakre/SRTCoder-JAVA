
public class P117_Prime_Number {

    public static void main(String[] args) {
        // Your code here

        int arr[] = { 23, 4, 5, 4, 65, 645, 645567, 3, 43, 3, 4, 231, 3, 454, 54, 24, 541, 32446, 44, 223, 45, 3, 5, 34,
                5456, 665 };

        for (int ele : arr) {
            if (isPrime(ele))
                System.out.print(ele + " ");
        }

    }

    public static boolean isPrime(int no) {
        for (int i = 2; i < no; i++) {
            if (no % i == 0)
                return false;
        }
        return true;
    }
}
