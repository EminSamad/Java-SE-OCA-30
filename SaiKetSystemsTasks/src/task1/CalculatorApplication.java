package task1;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("***************************************************");
            System.out.println("Operations :");
            System.out.println("Enter :   +   " + " --> for Addition");
            System.out.println("Enter :   -   " + " --> for Subtraction");
            System.out.println("Enter :   *   " + " --> for Multiplication");
            System.out.println("Enter :   /   " + " --> for Division");
            System.out.println("Enter :   %   " + " --> for Modulus");
            System.out.println("Enter :   q   " + " --> for Quitting");
            System.out.println("***************************************************");

            System.out.print("Enter the operation you want to perform: ");
            String operator = scanner.nextLine();

            if (operator.equals("q")) {
                System.out.println("Quitting the system. Goodbye!");
                break;
            }
            if (!(operator.equals("+") || operator.equals("-") || operator.equals("*")
                    || operator.equals("/") || operator.equals("%"))) {
                System.out.println("Invalid operation. Please try again.");
                continue;
            }
            System.out.print("Please enter the first number: ");
            int a = scanner.nextInt();
            System.out.print("Please enter the second number: ");
            int b = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer

            switch (operator) {
                case "+":
                    addition(a, b);
                    break;
                case "-":
                    subtraction(a, b);
                    break;
                case "*":
                    multiplication(a, b);
                    break;
                case "/":
                    if (b == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                    } else {
                        division(a, b);
                    }
                    break;
                case "%":
                    if (b == 0) {
                        System.out.println("Error: Cannot perform modulus with zero as divisor.");
                    } else {
                        modulus(a, b);
                    }
                    break;
                default:
                    System.out.println("Unknown error occurred.");
            }
        }
        scanner.close();
    }
    public static void addition(int a, int b) {
        System.out.println("Sum of given numbers: " + (a + b));
    }
    public static void subtraction(int a, int b) {
        System.out.println("The difference of the given numbers: " + (a - b));
    }
    public static void multiplication(int a, int b) {
        System.out.println("The product of the given numbers: " + (a * b));
    }
    public static void division(int a, int b) {
        System.out.println("Division of given numbers: " + ((double) a / b));
    }
    public static void modulus(int a, int b) {
        System.out.println("The remainder obtained from the division of the given numbers: " + (a % b));
    }
}
