lab 1a























Lab 1b
The `AlphabetWarGame` Java class is well-structured and designed to offer flexibility in defining custom strengths and determining winners based on input words. It features two constructors: a default constructor that initializes predefined strengths for specific characters, and an alternate constructor that allows users to pass custom strengths via `HashMap` arguments.

In the default configuration, the method `setDefaultStrengths()` assigns point values to each letter associated with the "left" and "right" teams. This setup allows for an intuitive and customizable scoring system.

To determine the winner, the class includes two main methods. The first, `alphabetWar(String word)`, calculates scores based on a single combined string, where letters from both sides are mixed together. The second method, `alphabetWar(String leftWord, String rightWord)`, accepts two separate strings for the left and right teams and calculates scores accordingly. A helper method, `calculateScore()`, efficiently sums scores by looking up values in the `HashMap`, ensuring modularity and reusability in the code.

The method `determineWinner()` handles the final decision-making process based on the calculated scores, also accounting for ties. 

Finally, the `main` method includes several test cases that verify the logic under different scenarios, demonstrating the functionality of the game. The code’s organization and clear separation of concerns make it easy to modify or extend, should additional characters or scoring rules be introduced.


