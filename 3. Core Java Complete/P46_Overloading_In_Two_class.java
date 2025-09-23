

class Parent {
    // Method in the parent class
    public void m1() {
        System.out.println("m1() parent");
    }
    
}

class Child extends Parent {
    // This is an OVERLOADED method, not an overridden one
    public void m1(int a) {
        System.out.println("m1(int a) child");
    }
}

public class P46_Overloading_In_Two_class {
    public static void main(String[] args) {
        Child obj = new Child();

        // This call executes the inherited method from Parent
        obj.m1();

        // This call executes the method in Child
        obj.m1(10);
    }
}