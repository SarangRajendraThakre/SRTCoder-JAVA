import java.util.Scanner;

public class P42_EvenNoSum {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int sum = 0;

    while (num > 0) {

     int d =   num%10;
     num/=10;
     if(d%2==0)
     {
      sum+=d;
     }


    }

    System.out.println(sum);

  }
}
