lab 1a

The `CreditCardValidator` Java class is a straightforward implementation designed to validate credit card numbers using a modified version of the Luhn algorithm. Here’s a breakdown of how the class works:

1. Constructor:
   - The constructor initializes the credit card number (as a `String` parameter) and calls the `validateCreditCard()` method immediately to check its validity.

2. Credit Card Validation:
   - Length Check: The method first verifies that the credit card number length is between 8 and 9 digits. If the length is outside this range, it outputs an "Invalid credit card number" message and exits.
   - Extracting and Reversing Digits: The last digit (the check digit) is separated from the rest of the number, and the remaining digits are reversed for easier processing according to the validation rules.
   - Doubling Process: Each digit in the reversed sequence is iterated over:
     - Digits in odd positions (according to 0-based indexing) are doubled.
     - If a doubled value exceeds 9, the individual digits of the doubled number are added together (e.g., a doubled value of 14 would result in 1 + 4 = 5).
   - Calculating the Check Digit: The sum of all processed digits is calculated, and the resulting number's modulo 10 is subtracted from 10 to get the calculated check digit. This ensures proper wraparound using `calculatedLastDigit = (10 - (sum % 10)) % 10`.
   - Validation: The calculated check digit is compared with the original last digit. If they match, the number is valid; otherwise, it is not.

3. Main Method:
   - The `main` method uses a `Scanner` to get user input for a credit card number, instantiates the `CreditCardValidator` class, and closes the scanner.

This implementation is efficient and straightforward, with clear modularity that makes it easy to follow the validation steps. It could be expanded to handle different card length requirements or custom validation rules if necessary.



Lab 1b

The `AlphabetWarGame` Java class is well-structured and designed to offer flexibility in defining custom strengths and determining winners based on input words. It features two constructors: a default constructor that initializes predefined strengths for specific characters, and an alternate constructor that allows users to pass custom strengths via `HashMap` arguments.

In the default configuration, the method `setDefaultStrengths()` assigns point values to each letter associated with the "left" and "right" teams. This setup allows for an intuitive and customizable scoring system.

To determine the winner, the class includes two main methods. The first, `alphabetWar(String word)`, calculates scores based on a single combined string, where letters from both sides are mixed together. The second method, `alphabetWar(String leftWord, String rightWord)`, accepts two separate strings for the left and right teams and calculates scores accordingly. A helper method, `calculateScore()`, efficiently sums scores by looking up values in the `HashMap`, ensuring modularity and reusability in the code.

The method `determineWinner()` handles the final decision-making process based on the calculated scores, also accounting for ties. 

Finally, the `main` method includes several test cases that verify the logic under different scenarios, demonstrating the functionality of the game. The code’s organization and clear separation of concerns make it easy to modify or extend, should additional characters or scoring rules be introduced.


