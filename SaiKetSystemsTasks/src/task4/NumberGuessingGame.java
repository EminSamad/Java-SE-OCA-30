package task4;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("***************************************************");
        System.out.println("Number Guessing Game!");
        System.out.println("You have 3 attempts.");
        System.out.println("***************************************************");

        int attempts = 3;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNum = random.nextInt(10) + 1;
        boolean check = true;

        while (check){
            System.out.print("Please Enter The Number for Guessing (from 1 until 10): ");
            int guessingNum = scanner.nextInt();

            if (guessingNum < 1 || guessingNum > 10) {
                System.out.println("Invalid input. Please enter a number between 1 and 10.");
                continue;
            }

            if(guessingNum < randomNum){
                System.out.println("Your guess is too low.");
                attempts--;
            } else if (guessingNum > randomNum) {
                System.out.println("Your guess is too high.");
                attempts--;
            }else {
                System.out.println("You found the number correctly.Congrats!");
                check = false;
            }

            if (attempts == 0){
                System.out.println("Your attempts are over.Exiting the System...");
                check=false;
            }
        }
        scanner.close();
    }

}
