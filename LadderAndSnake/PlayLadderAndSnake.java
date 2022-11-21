// -----------------------------------------------------
// Assignment 1
// Question: Part I and II
// Written by: Khalil Koudary 
//Assignment due date: Feb. 8th
// -----------------------------------------------------
/**
 * @author Khalil Koudary
 *
 */
import java.util.Scanner;
/**
 * This is the driver class of the program. This is the class that initiates the game. 
 * @param args
 */
public class PlayLadderAndSnake {

	/**
	 * This is the main method, it is important for the execution of the program.
	 */
	public static void main(String[] args) {
		
		//declare Scanner object
		Scanner keyIn = new Scanner (System.in);
		
		//ask user for number of players
		System.out.println("Enter the # of players for your game - Number must be between 2 and 4 inclusively:");
		int numOfPlayers = keyIn.nextInt();
		
		//declare an object of type LadderAndSnake
		LadderAndSnake game1; 
		
		//declaring number of attempts the user has at inputing the number of players for the game
		int n=1; 
		while(n<=4) {
			
			//if they enter a number less than 2 and greater than 4, before 4 tries are achieved
			if((numOfPlayers<2 || numOfPlayers >4) && (n<4)) {
				System.out.println("Bad Attempt " + n + " - Invalid # of players. Please enter a # between 2 and 4 inclusively:");
				numOfPlayers = keyIn.nextInt();
				n++;
			}
			
			//if they enter a number less than 2 and greater than 4 for the 4th time, the program will exit. 
			else if((numOfPlayers<2 || numOfPlayers >4) && (n==4)) {
				System.out.println("Bad Attempt 4! you have exhausted all your chances. Program will terminate!");
				System.exit(0);
			}
			else break; game1 = new LadderAndSnake(numOfPlayers);
		}
		
		System.out.println("Game is Played by " + numOfPlayers + " players.");
		System.out.println("Enter the names of the players:");
		Player[]players = new Player[numOfPlayers];
		
		//assigning names to players
		for(int i=0; i<numOfPlayers; i++) {
			System.out.println("Name of player" + (i+1) + ":");
			players[i]= new Player(keyIn.next());
		}
		
		//start the game. 
		Player.determineTurn(players);
		LadderAndSnake.play(players);
		}
	
	
	
	
	}
		

	
