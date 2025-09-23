


public class P181_VarargsAddition {

    // This method uses varargs to accept zero or more integer arguments.
    public static int add(int... numbers) {
        // If no numbers are passed, the sum is 0.
        int sum = 0;

        // Inside the method, 'numbers' is treated as an array.
        // We loop through each number to calculate the sum.
        for (int number : numbers) {
            sum += number; // Add the current number to the sum
        }
        
        return sum;
    }

    public static void main(String[] args) {
        // Let's call the add method with different numbers of arguments.
        
        int sum1 = add(5, 10);
        System.out.println("The sum of 5 and 10 is: " + sum1);

        int sum2 = add(1, 2, 3, 4, 5);
        System.out.println("The sum of 1, 2, 3, 4, and 5 is: " + sum2);

        int sum3 = add(100);
        System.out.println("The sum of just 100 is: " + sum3);
        
        int sum4 = add(); // Calling with no arguments
        System.out.println("The sum with no numbers is: " + sum4);
    }
}