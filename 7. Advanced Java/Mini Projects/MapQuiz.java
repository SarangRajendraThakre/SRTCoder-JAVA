import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapQuiz {

    private static int score = 0;
    private static final int TOTAL_QUESTIONS = 3; // Keep track of the total for the final score

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- QUESTION 1 ---
        Map<Character, Boolean> q1Answers = new HashMap<>();
        q1Answers.put('A', false); // A. Berlin
        q1Answers.put('B', false); // B. Madrid
        q1Answers.put('C', true);  // C. Paris (Correct)
        q1Answers.put('D', false); // D. Rome
        String q1Text = "Q1: What is the capital of France?\n" +
                        "A. Berlin\nB. Madrid\nC. Paris\nD. Rome";
        runQuestionWithMap(q1Text, q1Answers, scanner);

        // --- QUESTION 2 ---
        Map<Character, Boolean> q2Answers = new HashMap<>();
        q2Answers.put('A', false); // A. Mercury
        q2Answers.put('B', true);  // B. Mars (Correct)
        q2Answers.put('C', false); // C. Jupiter
        q2Answers.put('D', false); // D. Saturn
        String q2Text = "Q2: Which planet is known as the 'Red Planet'?\n" +
                        "A. Mercury\nB. Mars\nC. Jupiter\nD. Saturn";
        runQuestionWithMap(q2Text, q2Answers, scanner);

        // --- QUESTION 3 ---
        Map<Character, Boolean> q3Answers = new HashMap<>();
        q3Answers.put('A', false); // A. Atlantic Ocean
        q3Answers.put('B', false); // B. Indian Ocean
        q3Answers.put('C', true);  // C. Pacific Ocean (Correct)
        q3Answers.put('D', false); // D. Arctic Ocean
        String q3Text = "Q3: What is the largest ocean on Earth?\n" +
                        "A. Atlantic Ocean\nB. Indian Ocean\nC. Pacific Ocean\nD. Arctic Ocean";
        runQuestionWithMap(q3Text, q3Answers, scanner);

        // --- Final Summary ---
        System.out.println("\n*** Quiz Finished! ***");
        System.out.println("Your final score is: " + score + " / " + TOTAL_QUESTIONS);

        scanner.close();
    }

    public static void runQuestionWithMap(String question, Map<Character, Boolean> answers, Scanner scanner) {
        System.out.println("\n---------------------------------");
        System.out.println(question);
        System.out.print("Enter your choice (A, B, C, or D): ");

        char userAnswer = scanner.next().toUpperCase().charAt(0);

        // 1. Check if the input is a valid choice (key in the map)
        if (!answers.containsKey(userAnswer)) {
            System.out.println("⚠️ Invalid input! Please enter a valid option (A, B, C, or D).");
            // Recursive call to prompt again, or just return to skip the question.
            // For simplicity, we just return here.
            return;
        }

        // 2. Look up the result directly from the map
        boolean isCorrect = answers.get(userAnswer);

        if (isCorrect) {
            System.out.println("✅ Correct! +1 point.");
            score++;
        } else {
            // Find the correct answer to display
            char correctAnswer = findCorrectAnswer(answers);
            System.out.println("❌ Incorrect. The correct answer was " + correctAnswer + ".");
        }
    }

    private static char findCorrectAnswer(Map<Character, Boolean> answers) {
        // This method finds and returns the key ('A', 'B', etc.) whose value is 'true'
        for (Map.Entry<Character, Boolean> entry : answers.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return '?'; 
    }
}