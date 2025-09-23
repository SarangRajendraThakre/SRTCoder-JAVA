package Inheritance;

public class P_1_Demo {
    public static void main(String[] args) {
        P_1_ScientificCalc calc = new P_1_ScientificCalc();


        // for running this file you will have to do this  , simply runing the code will not work as this is under package and in separate files
        // javac P_1_Demo.java P_1_ScientificCalc.java P_1_SimpleCalc.java P_1_AdvancedCalc.java
        //    java -cp . Inheritance.P_1_Demo
        //

        // Integer operations
        System.out.println("Add: " + calc.add(4, 10));
        System.out.println("Sub: " + calc.sub(10, 4));
        System.out.println("Multiply: " + calc.multi(4, 4));
        System.out.println("Divide: " + calc.div(16, 4));
        System.out.println("Power: " + calc.pow(2, 8));

        System.out.println();

        // Double operations
        System.out.println("Add: " + calc.add(4.5, 10.2));
        System.out.println("Sub: " + calc.sub(10.5, 4.2));
        System.out.println("Multiply: " + calc.multi(4.5, 4.2));
        System.out.println("Divide: " + calc.div(16.5, 4.5));
        System.out.println("Power: " + calc.pow(2.5, 3.0));
    }
}
