

// The class for performing calculations
class Arithmetic {

    // Overloaded method 1: adds two integers
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    // Overloaded method 2: adds three integers
    public int add(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    // Overloaded method 3: adds four integers
    public int add(int num1, int num2, int num3, int num4) {
        return num1 + num2 + num3 + num4;
    }
}

// The driver class to run the code
public class  P44_Overloading_Arithmetic {
    public static void main(String[] args) {
        // 1. Create ONE object of the Arithmetic class
        Arithmetic calculator = new Arithmetic();

        // 2. Now, call the overloaded 'add' methods on that object
        int sum1 = calculator.add(1, 2);
        int sum2 = calculator.add(1, 2, 3);
        int sum3 = calculator.add(1, 2, 3, 4);

        System.out.println("Sum of two numbers: " + sum1); // Output: 3
        System.out.println("Sum of three numbers: " + sum2); // Output: 6
        System.out.println("Sum of four numbers: " + sum3); // Output: 10
    }
}