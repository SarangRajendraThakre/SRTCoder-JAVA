package ExceptionInJava;

public class P134_ThrowableMethod_GetMessage2 {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            Object obj = new String();
            // This invalid cast throws the exception.
            StringBuffer sb = (StringBuffer) obj;
        } catch (ClassCastException e) {
            System.out.println("catch");
            // e.getMessage() explains the invalid cast.
            System.out.println(e.getMessage());
        }
    }
}