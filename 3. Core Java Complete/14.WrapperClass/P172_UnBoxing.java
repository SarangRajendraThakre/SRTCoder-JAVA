
public class P172_UnBoxing {

    public static void main(String[] args) {

        int num = 123;
        Integer obj1 = Integer.valueOf(num);

        int num2 = obj1.intValue();

        System.out.println(num);
        System.out.println(obj1);
        System.out.println(num2);

    }
}
