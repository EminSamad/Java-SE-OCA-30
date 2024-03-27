package lesson6;
import java.util.Random;
import java.util.Scanner;
public class GuessNumber {
    public class GameGuess {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean check = true;
            int countGuess = 3;
            while (check){
                if(countGuess==0){
                    System.out.println("Your chance is over");
                    break;
                }
                System.out.println("Include numbers 1-10 " + countGuess-- + " you have a chance" );
                int guessNumber = scanner.nextInt();
                Random random = new Random();
                int randomNumber = random.nextInt(10);
                if(guessNumber < 0 || guessNumber >10){
                    System.out.println("Include the correct number");
                }else if(guessNumber<randomNumber){
                    System.out.println("The number you have included is small " + randomNumber);
                }else if(guessNumber > randomNumber){
                    System.out.println("The number you have included is big " + randomNumber);
                }else {
                    System.out.println("YESS !!!");
                    check = false;
                }
            }
        }

    }
}
