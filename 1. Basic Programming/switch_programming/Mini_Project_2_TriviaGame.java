import java.util.Scanner;

public class Mini_Project_2_TriviaGame {

    private static int score = 0; // Static variable to keep track of the score

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Question 1 ---
        String q1 = "What is the capital of France?\n" +
                    "A. Berlin\n" +
                    "B. Madrid\n" +
                    "C. Paris\n" +
                    "D. Rome";
        runQuestion(q1, 'C', scanner);

        // --- Question 2 ---
        String q2 = "Which planet is known as the 'Red Planet'?\n" +
                    "A. Venus\n" +
                    "B. Mars\n" +
                    "C. Jupiter\n" +
                    "D. Saturn";
        runQuestion(q2, 'B', scanner);

        // --- Question 3 ---
        String q3 = "What is the largest ocean on Earth?\n" +
                    "A. Atlantic Ocean\n" +
                    "B. Indian Ocean\n" +
                    "C. Arctic Ocean\n" +
                    "D. Pacific Ocean";
        runQuestion(q3, 'D', scanner);

        // --- Game Over Summary ---
        System.out.println("\n*** Quiz Finished! ***");
        System.out.println("Your final score is: " + score + " / 3");

        scanner.close();
    }

    /**
     * Runs a single quiz question, gets the user input, and validates it.
     * @param question The full question string to display.
     * @param correctAnswer The single character (A, B, C, D) of the correct answer.
     * @param scanner The Scanner object to read user input.
     */
    public static void runQuestion(String question, char correctAnswer, Scanner scanner) {
        System.out.println("\n---------------------------------");
        System.out.println(question);
        System.out.print("Enter your choice (A, B, C, or D): ");

        // Read the first character of the input and convert it to uppercase
        char userAnswer = scanner.next().toUpperCase().charAt(0);

        // The core logic: Using a switch statement for answer validation
        switch (userAnswer) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
                // Check if the selected answer is the correct one
                if (userAnswer == correctAnswer) {
                    System.out.println("✅ Correct!");
                    score++; // Increment the score
                } else {
                    System.out.println("❌ Incorrect. The correct answer was " + correctAnswer + ".");
                }
                break;
            default:
                // Handle invalid input
                System.out.println("⚠️ Invalid input! No points awarded.");
                break;
        }
    }
}