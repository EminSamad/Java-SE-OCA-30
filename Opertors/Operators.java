package Operators;
import java.util.Scanner;
public class Operators {

    public static void main(String[] args) {
        System.out.println("***************************************************");
        System.out.println("Operations :");
        System.out.println("Enter :   +   " + " --> for Addition");
        System.out.println("Enter :   -   " + " --> for Subtraction");
        System.out.println("Enter :   *   " + " --> for Multiplication");
        System.out.println("Enter :   /   " + " --> for Division");
        System.out.println("Enter :   %   " + " --> for Modulus");
        System.out.println("Enter :   q   " + " --> for Quiting");
        System.out.println("***************************************************");

        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter the transaction you want to calculate : ");
        String operator =scanner.nextLine();
        if(operator.equals("q")){
            System.out.println("Quiting the system");
        }else {
            System.out.print("Please enter the first digit:");
            int a = scanner.nextInt();
            System.out.print("Please enter the second digit:");
            int b = scanner.nextInt();

            if (!operator.equals("+") & !operator.equals("-") & !operator.equals("*") & !operator.equals("/") & !operator.equals("%")) {
                System.out.println("Please perform a correct operation...");
            } else {
                if (operator.equals("+")) {
                    System.out.println("Sum of given numbers: " + (a + b));
                }
                if (operator.equals("-")) {
                    System.out.println("The difference of the given numbers: " + (a - b));
                }
                if (operator.equals("*")) {
                    System.out.println("The product of the given numbers: " + (a * b));
                }
                if (operator.equals("/")) {
                    if (b == 0) {
                        System.out.println("When dividing, the denominator CANNOT be zero.");
                    } else {
                        System.out.println("Division of given numbers: " + (double) a / b);
                    }
                }
                if (operator.equals("%")) {
                    System.out.println("The remainder obtained from the division of the given numbers: " + (a % b));
                }
            }
        }
    }
}
