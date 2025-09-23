
public class P40_FibonnaciOfArray {

    public static void main(String[] args) {

        int[] arr = {1, 6, 4, 6}; 

        System.out.println("Fibonacci values for array elements:");
        for (int ele : arr) {
            
            
            if (ele < 0) {
                System.out.println("Fibonacci for " + ele + ": Not defined (input must be non-negative)");
            } else {
                System.out.println("Fibonacci for " + ele + ": " + fib(ele));
            }
        }
    }


    public static int fib(int n) { 
        
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }

        
        return fib(n - 1) + fib(n - 2);
    }
}