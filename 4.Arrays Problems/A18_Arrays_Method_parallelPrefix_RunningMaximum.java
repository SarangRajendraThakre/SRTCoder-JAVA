

import java.util.Arrays;

public class A18_Arrays_Method_parallelPrefix_RunningMaximum {
    public static void main(String[] args) {
        // An array of high scores achieved each day
        int[] dailyHighScores = {120, 150, 110, 180, 175};
        
        System.out.println("Daily High Scores: " + Arrays.toString(dailyHighScores));

        // Use parallelPrefix with Math.max to find the running maximum
        Arrays.parallelPrefix(dailyHighScores, (runningMax, currentScore) -> Math.max(runningMax, currentScore));

        System.out.println("All-time high score after each day: " + Arrays.toString(dailyHighScores));
    }
}