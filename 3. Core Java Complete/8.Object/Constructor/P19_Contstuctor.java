

class Human {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human() {
         this.name = "sarang";
    }
}

public class P19_Contstuctor {

    public static void main(String args[]) {

        Human obj = new Human();
        Human obj1 = new Human();

        System.out.println(obj.getName());

    }

}
