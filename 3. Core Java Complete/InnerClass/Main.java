package InnerClass;





public class Main {

    public void print()
    {
        System.out.println("inside the main ");
    }

  static  class B {



        public void show()
        {
            System.out.println("inside the B class");
        }
    }

    public static void main(String args[])
    {

        Main obj = new Main();

        // Main.B obj1 = obj.new B();
        // Main.B obj1 = new  Main.B();

        Main.B obj1 = new Main.B();

        obj.print();
        obj1.show();

    }
    
}
