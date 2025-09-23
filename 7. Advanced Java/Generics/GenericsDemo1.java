import java.util.ArrayList;

public class GenericsDemo1 {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add('2');
        list.add("sarang");
        list.add(4);

        Character str = (Character) list.get(0);
        System.out.println(str);

        String str2 = (String) list.get(1);
        System.out.println(str2);

    }
}
