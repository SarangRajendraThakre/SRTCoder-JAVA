package ExceptionInJava;

public class Main {

     public static void main(String[] args) {

        int a = 10 ;
        int c= 0;
        int b = 0 ;

        try{
             c = a/b;
        }
        catch(ArithmeticException e){
            System.out.println("your are dividing with the zero");

        }
         catch(Exception e)
         {
            System.out.println("something went wrong "+e);
         }
         System.out.println(c);
     }
}