class Human{

  private  int age;
  private String name ;
  private int percentage;


  public int getAge()
  {
     return age;
  }

public void setAge(int n)
{
    age = n;
}

  public String getName()
  {
     return name;
  }

  public void setName( String name)
  {
    this.name = name;
  }





    
}


public class Encapsulation {


   public static void main(String args[])
   {
    Human obj = new Human();

    obj.setAge(24);
    obj.setName("SrtCoder");

    System.out.println(obj.getAge() +" "+ obj.getName());

     
   }


    
}
