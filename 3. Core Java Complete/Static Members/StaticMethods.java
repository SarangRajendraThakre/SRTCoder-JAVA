class Mobile{

    public String  brand ;
    public String  color ;
    public String  name ;
   static  String  os ="android" ;


    public void show()
    {
        System.out.println( brand +" "+color + " "+name +" "+os) ;
    }

       public static void show1(Mobile obj)
    {
        System.out.println( obj.brand +" "+obj.color + " "+obj.name +" "+os) ;
    }


}


class StaticMethods{


    public static void main(String args[])
    {

      
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

           Mobile.show1(obj2);
        
    }
}