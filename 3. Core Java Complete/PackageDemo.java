// import Inheritance.AdvancedCalc;  

import PackageDemoinOveriding.*;

public class PackageDemo {

    public static void main(String args[])
    {
        AdvancedCalc obj = new AdvancedCalc();
        SimpleCalc obj1 = new SimpleCalc();

       int result =  obj.add(2,5);

       System.out.println(result);
    }
    
}
