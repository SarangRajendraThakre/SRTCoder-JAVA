import java.util.Arrays;
import java.util.Scanner;
import java.util.Random; // Import Random class for a more robust approach

public class P2_RandomAlphabets_Uppercase {

  // public static void main(String[] args) {

  // Scanner sc = new Scanner(System.in);
  // int size = sc.nextInt();

  // Random random = new Random();

  // char[] arr = new char[size];

  // for(int i = 0 ;i<size;i++ )
  // {

  // arr[i]= (char)(random.nextInt(26)+'A');
  // }

  // System.out.println(Arrays.toString(arr));

  // }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    Random random = new Random();

    int size = sc.nextInt();
    char arr[] = new char[size];

    for (int i = 0; i < size; i++) {
      char ch = (char) (random.nextInt(26) + 'A');
      arr[i] = ch;

    }
    System.out.println(Arrays.toString(arr));

  }

}

