import java.util.Arrays;

public class P32_MatchPlayerAndTrainers {

   
    public static void main(String[] args) {
        P32_MatchPlayerAndTrainers sol = new  P32_MatchPlayerAndTrainers();
 
        // Test Case 1
        int[] players1 = {4, 7, 9};
        int[] trainers1 = {8, 2, 5, 8};
        int result1 = sol.matchPlayersAndTrainers(players1, trainers1);
        System.out.println("Test Case 1:");
        System.out.println("Players: " + Arrays.toString(players1));
        System.out.println("Trainers: " + Arrays.toString(trainers1));
        System.out.println("Maximum Matchings: " + result1);
        System.out.println("--------------------");

        // Test Case 2
        int[] players2 = {1, 1, 1};
        int[] trainers2 = {10};
        int result2 = sol.matchPlayersAndTrainers(players2, trainers2);
        System.out.println("Test Case 2:");
        System.out.println("Players: " + Arrays.toString(players2));
        System.out.println("Trainers: " + Arrays.toString(trainers2));
        System.out.println("Maximum Matchings: " + result2);
        System.out.println("--------------------");

        // Test Case 3
        int[] players3 = {10, 20, 30};
        int[] trainers3 = {1, 2, 3};
        int result3 = sol.matchPlayersAndTrainers(players3, trainers3);
        System.out.println("Test Case 3:");
        System.out.println("Players: " + Arrays.toString(players3));
        System.out.println("Trainers: " + Arrays.toString(trainers3));
        System.out.println("Maximum Matchings: " + result3);
        System.out.println("--------------------");

        // Test Case 4
        int[] players4 = {1, 2, 3};
        int[] trainers4 = {5, 6, 7};
        int result4 = sol.matchPlayersAndTrainers(players4, trainers4);
        System.out.println("Test Case 4:");
        System.out.println("Players: " + Arrays.toString(players4));
        System.out.println("Trainers: " + Arrays.toString(trainers4));
        System.out.println("Maximum Matchings: " + result4);
        System.out.println("--------------------");

        // Test Case 5
        int[] players5 = {1, 2, 3, 4, 5};
        int[] trainers5 = {3, 4};
        int result5 = sol.matchPlayersAndTrainers(players5, trainers5);
        System.out.println("Test Case 5:");
        System.out.println("Players: " + Arrays.toString(players5));
        System.out.println("Trainers: " + Arrays.toString(trainers5));
        System.out.println("Maximum Matchings: " + result5);
        System.out.println("--------------------");

        // Test Case 6
        int[] players6 = {5, 6};
        int[] trainers6 = {1, 2, 7, 8, 9};
        int result6 = sol.matchPlayersAndTrainers(players6, trainers6);
        System.out.println("Test Case 6:");
        System.out.println("Players: " + Arrays.toString(players6));
        System.out.println("Trainers: " + Arrays.toString(trainers6));
        System.out.println("Maximum Matchings: " + result6);
        System.out.println("--------------------");

        // Test Case 7
        int[] players7 = {5, 5, 5};
        int[] trainers7 = {5, 5, 5};
        int result7 = sol.matchPlayersAndTrainers(players7, trainers7);
        System.out.println("Test Case 7:");
        System.out.println("Players: " + Arrays.toString(players7));
        System.out.println("Trainers: " + Arrays.toString(trainers7));
        System.out.println("Maximum Matchings: " + result7);
        System.out.println("--------------------");
    }

     public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int playerIdx = 0;
        int trainerIdx = 0;
        int matchCount = 0;

        while (playerIdx < players.length && trainerIdx < trainers.length) {
            if (players[playerIdx] <= trainers[trainerIdx]) {
                matchCount++;
                playerIdx++;
                trainerIdx++;
            } else {
                trainerIdx++;
            }
        }

        return matchCount;
    }

}


// https://gemini.google.com/app/3fd98628968343cf