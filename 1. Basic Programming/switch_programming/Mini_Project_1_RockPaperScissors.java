import java.util.Scanner;

public class Mini_Project_1_RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Rock-Paper-Scissors Validator ---");
        System.out.println("Enter your move (R for Rock, P for Paper, S for Scissors):");

        System.out.print("Player 1 Move: ");
        char player1 = scanner.next().toUpperCase().charAt(0);

        System.out.print("Player 2 Move: ");
        char player2 = scanner.next().toUpperCase().charAt(0);

        determineWinner(player1, player2);

        scanner.close();
    }

    public static void determineWinner(char p1, char p2) {
        System.out.println("\nPlayer 1 chose: " + getMoveName(p1));
        System.out.println("Player 2 chose: " + getMoveName(p2));

        // Outer switch: Check Player 1's move
        switch (p1) {
            case 'R': // Player 1 chose Rock
                // Inner switch: Check Player 2's move against Player 1's Rock
                switch (p2) {
                    case 'R':
                        System.out.println("Result: It's a Tie! 🤝");
                        break;
                    case 'P':
                        System.out.println("Result: Paper beats Rock. Player 2 Wins! 🏆");
                        break;
                    case 'S':
                        System.out.println("Result: Rock beats Scissors. Player 1 Wins! 🎉");
                        break;
                    default:
                        System.out.println("Error: Player 2 made an invalid move.");
                }
                break;

            case 'P': // Player 1 chose Paper
                // Inner switch: Check Player 2's move against Player 1's Paper
                switch (p2) {
                    case 'R':
                        System.out.println("Result: Paper beats Rock. Player 1 Wins! 🎉");
                        break;
                    case 'P':
                        System.out.println("Result: It's a Tie! 🤝");
                        break;
                    case 'S':
                        System.out.println("Result: Scissors beats Paper. Player 2 Wins! 🏆");
                        break;
                    default:
                        System.out.println("Error: Player 2 made an invalid move.");
                }
                break;

            case 'S': // Player 1 chose Scissors
                // Inner switch: Check Player 2's move against Player 1's Scissors
                switch (p2) {
                    case 'R':
                        System.out.println("Result: Rock beats Scissors. Player 2 Wins! 🏆");
                        break;
                    case 'P':
                        System.out.println("Result: Scissors beats Paper. Player 1 Wins! 🎉");
                        break;
                    case 'S':
                        System.out.println("Result: It's a Tie! 🤝");
                        break;
                    default:
                        System.out.println("Error: Player 2 made an invalid move.");
                }
                break;

            default:
                System.out.println("Error: Player 1 made an invalid move.");
        }
    }

    /** Helper method to translate the char code to a full word */
    private static String getMoveName(char move) {
        return switch (move) {
            case 'R' -> "Rock 🪨";
            case 'P' -> "Paper 📄";
            case 'S' -> "Scissors ✂️";
            default -> "Invalid Move";
        };
    }
}