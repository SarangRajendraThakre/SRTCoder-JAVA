package StreamAPI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Employee;

public class P16_MapAPI {

        public static void main(String[] args) {



                /** ********************************************** 1 **********************************************************************************/

                List<String> words = Arrays.asList("java", "spring", "react", "stream");

                // Using Stream API map() to convert to uppercase
                List<String> upperCaseWords = words.stream()
                                .map(String::toUpperCase) // Convert each string to uppercase
                                

                                .collect(Collectors.toList()); // Collect as List

                // Print the converted list
                System.out.println(upperCaseWords);

                

                /** ********************************************** 2 **********************************************************************************/

                List<String> numbersAsString = Arrays.asList("1", "2", "3", "4");
                List<Integer> numbers = numbersAsString.stream()
                                .map(Integer::parseInt) // Convert to Integer
                                .collect(Collectors.toList());
                System.out.println(numbers); // Output: [1, 2, 3, 4]

                /** ********************************************** 3 **********************************************************************************/


                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                List<String> dates = Arrays.asList("2024-01-01", "2024-02-15");

                List<String> formattedDates = dates.stream()
                                .map(date -> LocalDate.parse(date).format(formatter))
                                // .map(date -> LocalDate.parse(date).format(formatter) )
                                .collect(Collectors.toList());

                System.out.println(formattedDates); // Output: [01/01/2024, 15/02/2024]

                /** ********************************************** 4 **********************************************************************************/

                List<String> word2 = Arrays.asList("Java", "Spring", "Stream");
                List<Integer> lengths = word2.stream()
                                .map(String::length) // Get length of each word
                                .collect(Collectors.toList());
                System.out.println(lengths); // Output: [4, 6, 6]

                 /** ********************************************** 5 **********************************************************************************/

                List<Employee> employees = Arrays.asList(
                                new Employee(1, "Alice"),
                                new Employee(2, "Bob"),
                                new Employee(3, "Charlie"));
                List<String> names = employees.stream()
                                .map(Employee::getStudentName) // Extract names
                                .collect(Collectors.toList());
                System.out.println(names); // Output: [Alice, Bob, Charlie]

                /** ********************************************** 6 **********************************************************************************/

                List<Integer> square = Arrays.asList(1, 2, 3, 4, 5);
                List<Integer> squares = square.stream()
                                .map(n -> n * n) // Square each number
                                .collect(Collectors.toList());
                System.out.println(squares); // Output: [1, 4, 9, 16, 25]

        }
}
