package Inheritance;

public class P_1_AdvancedCalc extends P_1_SimpleCalc {

    // Multiplication
    public int multi(int a, int b) {
        return a * b;
    }

    // Division with zero check
    public int div(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return 0;
        }
        return a / b;
    }

    // Overloaded for double
    public double multi(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        if (b == 0.0) {
            System.out.println("Error: Division by zero");
            return 0.0;
        }
        return a / b;
    }
}
