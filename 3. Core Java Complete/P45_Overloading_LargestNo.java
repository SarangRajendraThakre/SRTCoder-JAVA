

public class P45_Overloading_LargestNo {

    // Overloaded method 1: finds the larger of two integers
    public int findLarge(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }

    // Overloaded method 2: finds the largest of three integers
    public int findLarge(int num1, int num2, int num3) {
        // This nested ternary operator finds the largest of the three
        return (num1 > num2 && num1 > num3) ? num1 : (num2 > num3 ? num2 : num3);
    }

    public static void main(String[] args) {
        // Create an object of the class
        P45_Overloading_LargestNo obj = new P45_Overloading_LargestNo ();

        // Call the first findLarge method
        int largestOfTwo = obj.findLarge(12, 5);
        System.out.println("Largest of two numbers: " + largestOfTwo); // Output: 12

        // Call the second findLarge method
        int largestOfThree = obj.findLarge(12, 5, 18);
        System.out.println("Largest of three numbers: " + largestOfThree); // Output: 18
    }
}