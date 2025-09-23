
public class P175_Cache_Memory_In_Wrapper {

    public static void main(String[] args) {


        Integer obj1 = 1000;
        Integer obj2 = 1100;
        System.out.println(obj1 == obj2);


        
        System.out.println("_____________-------------------");

        Integer obj3 = 1000;
        System.out.println(obj1 == obj3);
        System.out.println(obj1.equals(obj3));
  
        
 
        System.out.println("_____________-------------------");

        Float obj4 = (float) 12 ;
        Float obj5 = (float) 12 ;
        System.out.println(obj4 == obj5);
        System.out.println(obj4.equals(obj5));

        System.out.println("_____________-------------------");
        Long obj6 = 123L;
        Long obj7 = 123l;
        System.out.println(obj6 == obj7);
        System.out.println(obj6.equals(obj7));
    }
}
