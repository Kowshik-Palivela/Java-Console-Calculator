// Main class to run the calculator program.
import java.util.InputMismatchException;
import java.util.Scanner;

// A simple console-based calculator for basic arithmetic.
public class Calculator {

    // The main method is the entry point of the program.
    public static void main(String[] args) {
        // Create a Scanner object for reading user input.
        Scanner scanner = new Scanner(System.in);
        // Loop to allow the user to perform multiple calculations.
        while (true) {
            System.out.println("--- Console Calculator ---");
            System.out.println("Enter 'exit' at any point to quit the program.");

            // Get the first number from the user.
            double num1 = getNumber(scanner, "Enter the first number: ");
            if (Double.isNaN(num1)) {
                System.out.println("Exiting calculator.");
                break;
            }

            // Get the operator from the user.
            String operator = getOperator(scanner, "Enter an operator (+, -, *, /): ");
            if (operator.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator.");
                break;
            }

            // Get the second number from the user.
            double num2 = getNumber(scanner, "Enter the second number: ");
            if (Double.isNaN(num2)) {
                System.out.println("Exiting calculator.");
                break;
            }

            // Perform the calculation and print the result.
            double result = performCalculation(num1, num2, operator);
            // Check if the result is valid.
            if (!Double.isNaN(result)) {
                System.out.printf("Result: %.2f %s %.2f = %.2f%n", num1, operator, num2, result);
            }
            System.out.println(); // Add a blank line for readability.
        }
        // Close the scanner.
        scanner.close();
    }

    // Prompts for a number and handles validation.
    private static double getNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                return Double.NaN;
            }
            try {
                // Parse the input as a double.
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'exit'.");
            }
        }
    }

    // Prompts for an operator and handles validation.
    private static String getOperator(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String operator = scanner.nextLine().trim();
            if (operator.equalsIgnoreCase("exit") ||
                operator.equals("+") || operator.equals("-") ||
                operator.equals("*") || operator.equals("/")) {
                return operator;
            }
            System.out.println("Invalid operator. Please enter one of +, -, *, /.");
        }
    }

    // Performs the requested arithmetic calculation.
    private static double performCalculation(double num1, double num2, String operator) {
        double result = Double.NaN; // Initialize with NaN for error state.
        switch (operator) {
            case "+":
                result = add(num1, num2);
                break;
            case "-":
                result = subtract(num1, num2);
                break;
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                } else {
                    result = divide(num1, num2);
                }
                break;
            default:
                System.out.println("Error: Unknown operator.");
        }
        return result;
    }

    // Adds two numbers.
    private static double add(double a, double b) {
        return a + b;
    }

    // Subtracts the second number from the first.
    private static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplies two numbers.
    private static double multiply(double a, double b) {
        return a * b;
    }

    // Divides the first number by the second.
    private static double divide(double a, double b) {
        return a / b;
    }
}
