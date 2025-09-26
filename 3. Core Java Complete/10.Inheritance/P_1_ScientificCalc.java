package Inheritance;

public class P_1_ScientificCalc extends P_1_AdvancedCalc{

    // Power function
    public double pow(int a, int b) {
        return Math.pow(a, b);
    }

    // Overloaded for double
    public double pow(double a, double b) {
        return Math.pow(a, b);
    }
}
