
// https://gemini.google.com/app/05c1bc4f0660ab9e

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Frequency_Method_OfCharacter {
    public static void main(String[] args) {
        // 1. Initialize a LinkedHashMap to store Character and its frequency (Integer)
        Map<Character, Integer> map = 
            new LinkedHashMap<Character, Integer>();

        // 2. Initialize an ArrayList to store the random characters
        ArrayList<Character> list = 
            new ArrayList<Character>();

        // 3. Loop to generate 50 random characters (A-Z)
        int cnt = 0; // counter for the number of valid characters added to the list
        for (int i = 0; cnt != 50; ) { 
            // Generate a random number between 0 and 99, and cast it to a char
            char ch = (char) (Math.random() * 100); 

            // Check if the character is an uppercase letter (ASCII range 65 for 'A' to 90 for 'Z')
            if (ch >= 65 && ch <= 90) { 
                list.add(ch);
                cnt++;
            }
        } // The loop will continue until 50 valid uppercase characters are added to 'list'

        // 4. Create a LinkedHashSet from the list
        // This set will contain only the unique characters present in the 'list'
        LinkedHashSet<Character> set =
            new LinkedHashSet<Character>(list);

        // 5. Iterate through the unique characters (the set) and count their frequency in the list
        for (Character ele : set) {
            // Use Collections.frequency() to count how many times 'ele' appears in 'list'
            int count = Collections.frequency(list, ele);
            
            // Store the unique character and its count in the map
            map.put(ele, count);
        }

        // 6. Print the entire map
        System.out.println(map); 

        // 7. Iterate through the map's entries and print each one separately
        for (Map.Entry<Character, Integer> ele : map.entrySet()) {
            System.out.println(ele);
        }
    }
}