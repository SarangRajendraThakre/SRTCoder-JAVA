import java.util.Scanner;

public class P_2_Month_Name_from_Number {

    public static void main(String[] args) {

        System.out.println("Enter the number from 1 - 12 ");

        Scanner sc = new Scanner(System.in);

        while (true) {
              if (sc.hasNextInt()) {
            int month = sc.nextInt();
            switch (month) {
                case 1:
                System.out.println("January");

                    break;
        
                case 2:
                System.out.println("February");

                    break;
                case 3:
                System.out.println("March");

                    break;
                case 4:
                System.out.println("April");

                    break;
                case 5:
                System.out.println("May");

                    break;
                case 6:
                System.out.println("June");

                    break;
                case 7:
                System.out.println("July");
                    break;
                case 8:
                System.out.println("August");
                    break;
                case 9:
                System.out.println("September");
                    break;
                case 10:
                System.out.println("Octomber");
                    break;
                case 11:
                System.out.println("November");
                    break;
                case 12:
                System.out.println("December");

                    break;

                default:
                   System.out.println("Enter Valid number");
                    break;
            }

        } else {
            System.out.println("Enter the valid number");
            sc.nextInt();


        }
        }
      

    }
}