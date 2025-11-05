
public class P118_Count_Positve_Negative_elements {

  public static void main(String[] args) {
    // Your code here

    int[] arr = { 13, -547, 4, 54, -4, -5, 45, -45, 3, 4, 34, 3, 5, 45, 45 };

    int pcount = 0, ncount = 0;
    for (int ele : arr) {
      if (ele < 0)
        ncount++;
      else
        pcount++;

    }
    System.out.println("Postive no Count : " + pcount);
    System.out.println("Negative Count : " + ncount);
  }
}
