package org.spe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        // Main calculator loop
        do {
            displayMenu();
            System.out.print("Enter your choice (0 to exit): ");

            try {
                // Read user input for choice
                choice = scanner.nextInt();

                // Perform action based on user choice
                switch (choice) {
                    case 1:
                        double numSquareRoot = readDoubleInput("Enter a number: ");
                        double squareRootResult = squareRoot(numSquareRoot);
                        logger.info("Square root of " + numSquareRoot + " is : " + squareRootResult);
                        break;
                    case 2:
                        int numFactorial = readIntInput();
                        long factorialResult = factorial(numFactorial);
                        logger.info("Factorial of " + numFactorial + " is : " + factorialResult);
                        break;
                    case 3:
                        double numLog = readDoubleInput("Enter a number: ");
                        double logResult = naturalLogarithm(numLog);
                        logger.info("Natural Logarithm of " + numLog + " is : " + logResult);
                        break;
                    case 4:
                        double base = readDoubleInput("Enter the base: ");
                        double exponent = readDoubleInput("Enter the exponent: ");
                        double powerResult = powerFunction(base, exponent);
                        logger.info(base + " raised to the " + exponent + " is : " + powerResult);
                        break;
                    case 0:
                        System.out.println("Exiting the calculator!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (InputMismatchException e) {
                // Handle invalid input (non-integer)
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // consume the invalid input
                choice = -1; // reset choice to repeat the loop
            }

            System.out.println();
        } while (choice != 0);

        // Close the scanner
        scanner.close();
    }

    // Display the calculator menu
    private static void displayMenu() {
        System.out.println("Scientific Calculator");
        System.out.println("--------------------------");
        System.out.println("1. Square root");
        System.out.println("2. Factorial");
        System.out.println("3. Natural logarithm (base е)");
        System.out.println("4. Power function");
        System.out.println("0. Exit");
    }

    // Square Root
    public static double squareRoot(double num) {
        if (num < 0) {
            // Log an error for invalid input
            logger.error("Square root is undefined for negative numbers!");
            return Double.NaN; // Return NaN for undefined result
        }

        // Calculate and log the square root
        return Math.sqrt(num);
    }

    // Factorial
    public static long factorial(int num) {
        if (num < 0) {
            // Log an error for invalid input
            logger.error("Factorial is undefined for negative numbers!");
            return -1; // Return -1 for undefined result
        }

        // Calculate and log the factorial
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    // Natural Logarithm
    public static double naturalLogarithm(double num) {
        if (num <= 0) {
            // Log an error for invalid input
            logger.error("Natural logarithm is undefined for non-positive numbers!");
            return Double.NaN; // Return NaN for undefined result
        }

        // Calculate and log the natural logarithm
        return Math.log(num);
    }

    // Power function
    public static double powerFunction(double base, double exponent) {
        // Calculate and log the power function result
        return Math.pow(base, exponent);
    }

    // Read a double input from the user
    private static double readDoubleInput(String message) {
        System.out.print(message);
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                logger.error("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // consume the invalid input
            }
        }
    }

    // Read an integer input from the user
    private static int readIntInput() {
        System.out.print("Enter a number: ");
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                logger.error("Invalid input! Please enter a valid integer.");
                scanner.nextLine(); // consume the invalid input
            }
        }
    }
}
