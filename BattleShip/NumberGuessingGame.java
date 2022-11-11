import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuessingGame {

    public static int random = ThreadLocalRandom.current().nextInt();

    public static void main(String[] args){
        int i=5;
        Scanner keyIn = new Scanner(System.in);

        while(i>=1){
            System.out.println("You have " + i+" tries to guess the randomly generated number:");
            int input = keyIn.nextInt();
            boolean guess = startGame(input);
            if(guess==false)
                i--;
            else if(guess==true)
                break;
        }
        if(i==0){
            System.out.println("Sorry, you've exhausted your number of tries");
        }

    }

    public static boolean startGame(int n){
        boolean guess = false;
        if(n>random){
            System.out.println("The guessed number is higher than the generated number");
        } else if(n==random){
            System.out.println("Congrats! You guessed the number");
            guess=true;
        }else if(n<random){
            System.out.println("The guessed number is lower than the generated number");
        }
        return guess;
    }
}
