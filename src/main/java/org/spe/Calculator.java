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
                        squareRoot(numSquareRoot);
                        break;
                    case 2:
                        int numFactorial = readIntInput("Enter a number: ");
                        factorial(numFactorial);
                        break;
                    case 3:
                        double numLog = readDoubleInput("Enter a number: ");
                        naturalLogarithm(numLog);
                        break;
                    case 4:
                        double base = readDoubleInput("Enter the base: ");
                        double exponent = readDoubleInput("Enter the exponent: ");
                        powerFunction(base, exponent);
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
    private static void squareRoot(double num) {
        if (num < 0) {
            // Log an error for invalid input
            logger.error("Square root is undefined for negative numbers!");
            return;
        }

        // Calculate and log the square root
        double result = Math.sqrt(num);
        logger.info("Square root of " + num + " is " + result);
    }

    // Factorial
    private static void factorial(int num) {
        if (num < 0) {
            // Log an error for invalid input
            logger.error("Factorial is undefined for negative numbers!");
            return;
        }

        // Calculate and log the factorial
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        logger.info("Factorial of " + num + " is " + result);
    }

    // Natural Logarithm
    private static void naturalLogarithm(double num) {
        if (num <= 0) {
            // Log an error for invalid input
            logger.error("Natural logarithm is undefined for non-positive numbers!");
            return;
        }

        // Calculate and log the natural logarithm
        double result = Math.log(num);
        logger.info("Natural logarithm (base е) of " + num + " is " + result);
    }

    // Power Function
    private static void powerFunction(double base, double exponent) {
        // Calculate and log the power function result
        double result = Math.pow(base, exponent);
        logger.info(base + " raised to the power of " + exponent + " is " + result);
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
    private static int readIntInput(String message) {
        System.out.print(message);
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
