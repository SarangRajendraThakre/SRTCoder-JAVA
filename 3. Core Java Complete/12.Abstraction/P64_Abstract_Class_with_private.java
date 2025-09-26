

abstract class Demo {
    private void secretInstance() {
        System.out.println("Private instance method in abstract class");
    }

    public static void callSecret(Demo obj) {
        obj.secretInstance(); // ✅ Allowed if you pass a subclass object
    }

    public static void add()
    {
        System.out.println("Addition");
    }
  
}

class Child extends Demo { }

public class P64_Abstract_Class_with_private {
    public static void main(String[] args) {
        Child c = new Child();
        Demo.callSecret(c);
        Demo.add();


    }
}
