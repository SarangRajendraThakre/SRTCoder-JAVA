
class Mobile {

    public String brand;
    public String color;
    public String name;
    static String os = "android";

    public void show() {
        System.out.println(brand + " " + color + " " + name + " " + os);
    }

}

class StaticVariables {

    public static void main(String args[]) {

        Mobile obj1 = new Mobile();
        obj1.brand = "samsung";
        obj1.color = "black";
        obj1.name = "j7 nxt";

        obj1.show();

        Mobile obj2 = new Mobile();
        obj2.brand = "redmi";
        obj2.color = "golden";
        obj2.name = "redmi note 10 pro";

        obj2.show();

    }
}