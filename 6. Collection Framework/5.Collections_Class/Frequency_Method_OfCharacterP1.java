
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Frequency_Method_OfCharacterP1 {

    public static void main(String[] args) {

        ArrayList<Character> list = new ArrayList<>();

        int cnt = 0;
        for (int i = 0; cnt < 50;) {

            char ch = (char) (Math.random() * 100);
            if (ch >= 65 && ch <= 90) {
                list.add(ch);
                cnt++;
            }
            i++;
        }

        LinkedHashSet<Character> set = new LinkedHashSet<>(list);
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (Character ele : set) {
            int count = Collections.frequency(list, ele);

            map.put(ele, count);
        }

        System.out.println(map);

    }
}