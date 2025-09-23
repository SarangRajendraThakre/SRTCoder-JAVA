public class P34_SumOfPrimeAtEvenIndex {

    public static void main(String[] args) {
        // 1,2,3,4,5,6
        int arr[] = { 4, 5, 6, 2, 10, 4 };

        int sum = findSum(arr);
        System.out.println(sum);

    }

    // public static int findSum(int[] arr) {
    //     int sum = 0;
    //     for (int i = 0; i < arr.length; i++) {

    //         if (isPrime(arr[i])) {

    //             if ((i + 1) % 2 == 0) {
    //                 sum += arr[i];
    //             }

    //         }

    //     }
    //     return sum;
    // }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false;

        }

        return true;
    }


       public static int findSum(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i+=2) {

            if (isPrime(arr[i])) {  sum+=arr[i];

                

            }

        }
        return sum;
    }


}
