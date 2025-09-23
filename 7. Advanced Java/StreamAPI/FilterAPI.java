package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAPI {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        // Using Stream API filter() to get even numbers
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n%2 != 0) // Filter even numbers
                                           .collect(Collectors.toList()); // Collect as List


                                    numbers.stream()
                                           .filter(n -> n%2 == 0)
                                           .collect(Collectors.toList());       

        // Print even numbers
        System.out.println(evenNumbers);
    }
}


