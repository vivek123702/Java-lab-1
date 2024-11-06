import java.util.Scanner;

public class CreditCardValidator {
    private String ccNumber;

    // Constructor to read credit card number
    public CreditCardValidator(String ccNumber) {
        this.ccNumber = ccNumber;
        validateCreditCard();
    }

    // Method to validate the credit card number
    private void validateCreditCard() {
        if (ccNumber.length() < 8 || ccNumber.length() > 9) {
            System.out.println("Invalid credit card number.");
            return;
        }

        char lastDigitChar = ccNumber.charAt(ccNumber.length() - 1);
        int lastDigit = Character.getNumericValue(lastDigitChar);
        String remainingDigits = ccNumber.substring(0, ccNumber.length() - 1);

        // Reverse the remaining digits
        String reversedDigits = new StringBuilder(remainingDigits).reverse().toString();

        int[] doubledDigits = new int[reversedDigits.length()];
        for (int i = 0; i < reversedDigits.length(); i++) {
            int digit = Character.getNumericValue(reversedDigits.charAt(i));

            // Double the digits at odd positions (0-based index, so 1, 3, 5, etc. are 0, 2,
            // 4)
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit = (digit % 10) + (digit / 10); // Add the digits of the double-digit number
                }
            }
            doubledDigits[i] = digit;
        }

        // Calculate the sum of the doubled digits
        int sum = 0;
        for (int digit : doubledDigits) {
            sum += digit;
        }

        // Step e: Subtract the last digit from 10
        int calculatedLastDigit = (10 - (sum % 10)) % 10; // Ensure it wraps around correctly

        // Step f: Compare with the last digit
        if (calculatedLastDigit == lastDigit) {
            System.out.println("The credit card number is valid.");
        } else {
            System.out.println("The credit card number is invalid.");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String input = scanner.nextLine();
        new CreditCardValidator(input);
        scanner.close();
    }
}
