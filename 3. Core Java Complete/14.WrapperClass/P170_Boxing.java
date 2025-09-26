
public class P170_Boxing {

    @SuppressWarnings("removal")
    public static void main(String[] args) {

        
        int num = 123;

        Integer obj1 = new Integer(num);
        Integer obj2 = Integer.valueOf(num);

        System.out.println(num);
        System.out.println(obj1);
        System.out.println(obj2);
    }
}


