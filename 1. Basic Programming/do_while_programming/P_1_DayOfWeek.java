import java.util.Scanner;

class P_1_DayOfWeek {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int day;
        boolean validInput = false; // Flag to control the loop

        while (!validInput) { // Loop continues as long as input is not valid
            System.out.println("Enter a number between 1 and 7 to get the day of the week:");

            // Check if the next input is an integer
            if (sc.hasNextInt()) {
                day = sc.nextInt(); // Read the integer

                switch (day) {
                    case 1:
                        System.out.println("Monday");
                        validInput = true; // Input is valid, exit loop
                        break;
                    case 2:
                        System.out.println("Tuesday");
                        validInput = true;
                        break;
                    case 3:
                        System.out.println("Wednesday");
                        validInput = true;
                        break;
                    case 4:
                        System.out.println("Thursday");
                        validInput = true;
                        break;
                    case 5:
                        System.out.println("Friday");
                        validInput = true;
                        break;
                    case 6:
                        System.out.println("Saturday");
                        validInput = true;
                        break;
                    case 7:
                        System.out.println("Sunday");
                        validInput = true;
                        break;
                    default:
                        System.out.println("Invalid input: " + day + ". Please enter a number between 1 and 7.");
                        // validInput remains false, so the loop will repeat
                }
            } else {
                // If input is not an integer (e.g., user types "abc")
                System.out.println("Invalid input. Please enter a numerical value.");
                sc.next(); // Consume the invalid input to prevent an infinite loop
                // validInput remains false, so the loop will repeat
            }
        }

        sc.close(); // Close the scanner when the loop exits and we're done
    }
}