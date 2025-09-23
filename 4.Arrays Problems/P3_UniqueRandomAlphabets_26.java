import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections; 

public class P3_UniqueRandomAlphabets_26 {

public static void main(String[] args) {
    
    int TOTAL_ALPHABET_SIZE = 26;
    Random random = new Random();

    ArrayList<Character> characterList = new ArrayList<>();

    for(char c = 'A' ;c<='Z' ;c++)
    {
        characterList.add(c);
    }
    System.out.println(characterList);

    Collections.shuffle(characterList , random);;
    System.out.println(characterList);
     char[] character = new char[TOTAL_ALPHABET_SIZE];

    for(int  j = 0 ;j<TOTAL_ALPHABET_SIZE ;j++)
    {
         character[j] = characterList.get(j);

    }

    System.out.println(Arrays.toString(character));


}




}