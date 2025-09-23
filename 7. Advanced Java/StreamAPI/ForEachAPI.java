package StreamAPI;

import java.util.Arrays;
import java.util.List;

public class ForEachAPI {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        List<String> sentenses = Arrays.asList("sarang","yadnesg");

        // Using Stream API forEach()
        numbers.stream().forEach(System.out::println);
        sentenses.stream().forEach(System.out::println);
    }
}

    

