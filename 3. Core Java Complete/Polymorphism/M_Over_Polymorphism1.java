

class Parent {
    public void m1() {
        System.out.println("m1() Parent");
    }
}

class Child extends Parent {
    public void m1(int a) {
        System.out.println("m1(int a) Child");
    }
}

// Property 1 

// If a subclass and superclass contains non-static method with same Name and Different Formal Argument 
// The subclass will inherit the behaviour  from the parent class , that mean
// the child class will contain Overloaded() method 


public class M_Over_Polymorphism1 {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.m1();
        obj.m1(10000);
    }
}
