class Mobile {

    public String brand;
    public String color;
    public String name;
    static String os;

    static {

        os = "android";
        System.out.println("inside the static");

    }

    public Mobile() {
        this.brand = "samsung";
        this.color = "gold";
        this.name = "j7 nxt";

        System.out.println("inside the constructor");
    }

    public void show() {
        System.out.println(brand + " " + color + " " + name + " " + os);
    }

    public static void show1(Mobile obj) {
        System.out.println(obj.brand + " " + obj.color + " " + obj.name + " " + os);
    }

}

class StaticBlock {

    public static void main(String args[]) throws ClassNotFoundException {

        Class.forName("Mobile");     

        // Mobile obj1 = new Mobile();

        // obj1.show();

        // Mobile obj2 = new Mobile();

        // obj2.show();

        // Mobile.show1(obj2);

    }
}