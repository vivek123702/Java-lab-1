import java.util.HashMap;
import java.util.Map;

public class AlphabetWarGame {
    private Map<Character, Integer> leftStrengths;
    private Map<Character, Integer> rightStrengths;

    // Default constructor with predefined strengths
    public AlphabetWarGame() {
        leftStrengths = new HashMap<>();
        rightStrengths = new HashMap<>();
        setDefaultStrengths();
    }

    // Constructor to customize strengths
    public AlphabetWarGame(Map<Character, Integer> leftStrengths, Map<Character, Integer> rightStrengths) {
        this.leftStrengths = leftStrengths;
        this.rightStrengths = rightStrengths;
    }

    // Method to set default strengths
    private void setDefaultStrengths() {
        leftStrengths.put('w', 4);
        leftStrengths.put('p', 3);
        leftStrengths.put('b', 2);
        leftStrengths.put('s', 1);

        rightStrengths.put('m', 4);
        rightStrengths.put('q', 3);
        rightStrengths.put('d', 2);
        rightStrengths.put('z', 1);
    }

    // Method to determine the winner based on a single word
    public String alphabetWar(String word) {
        int leftScore = 0;
        int rightScore = 0;

        for (char c : word.toCharArray()) {
            if (leftStrengths.containsKey(c)) {
                leftScore += leftStrengths.get(c);
            } else if (rightStrengths.containsKey(c)) {
                rightScore += rightStrengths.get(c);
            }
        }

        return determineWinner(leftScore, rightScore);
    }

    // Method to determine the winner based on separate left and right words
    public String alphabetWar(String leftWord, String rightWord) {
        int leftScore = calculateScore(leftWord, leftStrengths);
        int rightScore = calculateScore(rightWord, rightStrengths);

        return determineWinner(leftScore, rightScore);
    }

    // Helper method to calculate score based on the strengths
    private int calculateScore(String word, Map<Character, Integer> strengths) {
        int score = 0;
        for (char c : word.toCharArray()) {
            score += strengths.getOrDefault(c, 0);
        }
        return score;
    }

    // Helper method to determine the winner
    private String determineWinner(int leftScore, int rightScore) {
        if (leftScore > rightScore) {
            return "Left side wins!";
        } else if (rightScore > leftScore) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    // Main method to test the game
    public static void main(String[] args) {
        AlphabetWarGame game = new AlphabetWarGame();

        // Test cases
        System.out.println(game.alphabetWar("z")); // Right side wins!
        System.out.println(game.alphabetWar("zdqmwpbs")); // Let's fight again!
        System.out.println(game.alphabetWar("wwwwwwz")); // Left side wins!

        // Example with separate left and right words
        System.out.println(game.alphabetWar("wwwwww", "zz")); // Left side wins!
        System.out.println(game.alphabetWar("p", "m")); // Let's fight again!
    }
}
