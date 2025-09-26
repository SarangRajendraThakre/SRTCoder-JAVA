class Demo2 {

    void display(long a) {
        System.out.println("long version: " + a);
    }

    void display(float a) {
        System.out.println("float version: " + a);
    }

    void display(double a) {
        System.out.println("double version: " + a);
    }
}

public class M_Over_Polymorphism42 {
    public static void main(String[] args) {
        Demo2 d = new Demo2();
        int i = 100;

        d.display(i); // int → long (promoted) → chooses long version
        d.display(12.5f); // float exact match
        d.display(12.5); // double exact match
    }
}



// Property 4

// if an exact Match isn't found , java automatically Promotes the type to the next widest type 