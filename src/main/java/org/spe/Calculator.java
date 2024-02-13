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

        do {
            displayMenu();
            System.out.print("Enter your choice (0 to exit): ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        squareRoot();
                        break;
                    case 2:
                        factorial();
                        break;
                    case 3:
                        naturalLogarithm();
                        break;
                    case 4:
                        powerFunction();
                        break;
                    case 0:
                        System.out.println("Exiting the calculator!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // consume the invalid input
                choice = -1; // reset choice to repeat the loop
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Scientific Calculator");
        System.out.println("--------------------------");
        System.out.println("1. Square root");
        System.out.println("2. Factorial");
        System.out.println("3. Natural logarithm (base е)");
        System.out.println("4. Power function");
        System.out.println("0. Exit");
    }

    private static void squareRoot() {
        System.out.println("Enter a number: ");

        try {
            double num = scanner.nextDouble();

            if (num < 0) {
                logger.error("Square root is undefined for negative numbers!");
                return;
            }

            double result = Math.sqrt(num);
            logger.info("Square root of " + num + " is " + result);

        } catch (InputMismatchException e) {
            logger.error("Invalid input! Please enter a valid number.");
            scanner.nextLine(); // consume the invalid input
        }
    }

    private static void factorial() {
        System.out.println("Enter a number: ");

        try {
            int num = scanner.nextInt();

            if (num < 0) {
                logger.error("Factorial is undefined for negative numbers!");
                return;
            }

            long result = 1;

            for (int i = 1; i <= num; i++) {
                result *= i;
            }

            logger.info("Factorial of " + num + " is " + result);

        } catch (InputMismatchException e) {
            logger.error("Invalid input! Please enter a valid integer.");
            scanner.nextLine(); // consume the invalid input
        }
    }

    private static void naturalLogarithm() {
        System.out.println("Enter a number: ");

        try {
            double num = scanner.nextDouble();

            if (num <= 0) {
                logger.error("Natural logarithm is undefined for non-positive numbers!");
                return;
            }

            double result = Math.log(num);
            logger.info("Natural logarithm (base е) of " + num + " is " + result);

        } catch (InputMismatchException e) {
            logger.error("Invalid input! Please enter a valid number.");
            scanner.nextLine(); // consume the invalid input
        }
    }

    private static void powerFunction() {
        System.out.println("Enter the base: ");

        try {
            double base = scanner.nextDouble();

            System.out.println("Enter the exponent: ");

            try {
                double exponent = scanner.nextDouble();

                double result = Math.pow(base, exponent);
                logger.info(base + " raised to the power of " + exponent + " is " + result);
                
            } catch (InputMismatchException e) {
                logger.error("Invalid input! Please enter a valid number for the exponent.");
                scanner.nextLine(); // consume the invalid input
            }
        } catch (InputMismatchException e) {
            logger.error("Invalid input! Please enter a valid number for the base.");
            scanner.nextLine(); // consume the invalid input
        }
    }
}

