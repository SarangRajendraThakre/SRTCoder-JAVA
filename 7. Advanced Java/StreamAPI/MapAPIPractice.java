package StreamAPI;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAPIPractice {

        public static void main(String[] args) {

        List<String> words = Arrays.asList("sarang","yadnesh","ayush","vidya","ram");

        List<String> upperCase = words.stream()
                                 .map(String::toUpperCase)
                                 .collect(Collectors.toList());

        System.out.println(upperCase);
        
        





        }
}
