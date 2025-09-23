class Human {
    private String name;
    private int age;


    public Human(int age , String name  )
    {
        this.age = age;
        this.name = name;

    }

    public void show(){
           
        System.out.println(age);
    }

}

public class AnonymsObject {

    public static void main(String args[]) {
 

        new Human(24, "sarang").show();           // anonyms object
        
 
    }
}
