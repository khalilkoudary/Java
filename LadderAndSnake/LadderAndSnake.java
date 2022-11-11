// -----------------------------------------------------
// Assignment 1
// Question: Part I and II
// Written by: Khalil Koudary (ID: 40088454)
//Assignment due date: Feb. 8th
// -----------------------------------------------------
/**
 * This is the class that contains information about the ladder and snake board.
 * It also tracks the movement of the players and announces a winner.
 * @author Khalil Koudary
 *
 */
public class LadderAndSnake {
	
	//private attributes, every object has a 10x10 board and a number of players
	private static int[][] board = {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20},{21,22,23,24,25,26,27,28,29,30},{31,32,33,34,35,36,37,38,39,40},{41,42,43,44,45,46,47,48,49,50},{51,52,53,54,55,56,57,58,59,60},{61,62,63,64,65,66,67,68,69,70},{71,72,73,74,75,76,77,78,79,80},{81,82,83,84,85,86,87,88,89,90},{91,92,93,94,95,96,97,98,99,100}}; 
	private int numberOfPlayers; 
	/**
	 * default constructor, sets the private attributes to the zero of their type.
	 */
	//default constructor
	public LadderAndSnake() {
		this (0);
	}
	/**
	 * constructor that takes one parameter (players) and sets the numberOfPlayers of the calling object
	 * equal to the value in the parameter. 
	 * @param players number of players
	 */
	//constructor with one parameter
	public LadderAndSnake(int players) {
		this.numberOfPlayers = players; 
		this.board= new int[10][10];
	}
	/**
	 * accessor method to get the numberOfPlayers of the calling object.
	 * @return number of players
	 */
	//accessor methods
	public int getPlayers() {
		return this.numberOfPlayers;
	}
	/**
	 * accessor method to get the board of the calling object. 
	 * @return board
	 */
	public int[][]getBoard(){
		return this.board;
	}
	/**
	 * mutator method that takes an integer parameter (players) and assigns the
	 * numberOfPlayers of the calling object to be equal to the value in the parameter. 
	 * @param players number of players
	 */
	//mutator methods
	public void setPlayers(int players) {
		this.numberOfPlayers = players;
	}
	/** 
	 * mutator method that takes a 2D array of integers as a parameter and assigns
	 * the board of the calling object to be equal to the value in the parameter.
	 * @param board 
	 */
	public void setBoard(int[][] board) {
		this.board = board;
	}
	/**
	 * toString method that returns a string mentioning the number of players of the calling object.
	 */
	//toString method
	public String toString() {
		return "Game is played by " + this.numberOfPlayers + " players";
	}
	/**
	 * method that returns a random number between 1 and 6
	 * @return an integer between 1 and 6 (inclusively)
	 */
	// returns a random number between 1 and 6
	public static int flipDice() {
		 int max = 6;
	        int min = 1;
	        int range = max - min + 1;
	        return (int) (Math.random() * range + min);

	}
	/**
	 * Takes an array of Player object and starts the game between the players
	 * @param players all the players in the game
	 */
	//starts the game
	public static void play(Player[] players) {
		
		//start all players at square 0
			for(int i=0; i<players.length; i++) {
			players[i].setPosition(0);
			System.out.println(players[i].getName() + " will start at square " + players[i].getPosition());
		}
			
		while(players[0].getPosition()<100 || players[1].getPosition() <100 || players[2].getPosition() <100 || players[3].getPosition() <100) {	
		for(int i=0; i<players.length;i++) {
			//get the players to flip the dice and set the dice value
			players[i].setDice(LadderAndSnake.flipDice());
			//set the position of the players which is equal to their original position + dice value
			players[i].setPosition(players[i].getDice() + players[i].getPosition());
			
			//in case players get over square 100
			if(players[i].getPosition()>100) {
				int x = players[i].getPosition()-100;
				players[i].setPosition(100-x);
				System.out.println(players[i].getName() + " got a dice value of " + players[i].getDice() + "; now in square " + players[i].getPosition());
			}
			
			//winning player
			else if(players[i].getPosition()==100) {
				System.out.println(players[i].getName() + " got a dice value of " + players[i].getDice() + "; now in square " + players[i].getPosition()+ ". " + players[i].getName()+" won!");
				System.exit(0);
			}
			System.out.println(players[i].getName() + " got a dice value of " + players[i].getDice() + "; now in square " + players[i].getPosition());
			
			//if a player reaches a ladder
			if(players[i].getPosition()==1) {
				players[i].setPosition(38);
				System.out.println(players[i].getName() + " reached the bottom of a ladder; gone up to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==4) {
				players[i].setPosition(14);
				System.out.println(players[i].getName() + " reached the bottom of a ladder; gone up to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==9) {
				players[i].setPosition(9);
				System.out.println(players[i].getName() + " reached the bottom of a ladder; gone up to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==21) {
				players[i].setPosition(42);
				System.out.println(players[i].getName() + " reached the bottom of a ladder; gone up to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==28) {
				players[i].setPosition(84);
				System.out.println(players[i].getName() + " reached the bottom of a ladder; gone up to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==36) {
				players[i].setPosition(44);
				System.out.println(players[i].getName() + " reached the bottom of a ladder; gone up to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==51) {
				players[i].setPosition(67);
				System.out.println(players[i].getName() + " reached the bottom of a ladder; gone up to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==71) {
				players[i].setPosition(91);
				System.out.println(players[i].getName() + " reached the bottom of a ladder; gone up to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==80) {
				players[i].setPosition(100);
				System.out.println(players[i].getName() + " reached the bottom of a ladder; gone up to square " + players[i].getPosition());
				System.out.println(players[i].getName() + " wins!");
				System.exit(0);
			}
			
			//if a player reaches a snake
			else if(players[i].getPosition()==16) {
				players[i].setPosition(6);
				System.out.println(players[i].getName() + " reached the head of a snake; gone down to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==48) {
				players[i].setPosition(30);
				System.out.println(players[i].getName() + " reached the head of a snake; gone down to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==62) {
				players[i].setPosition(19);
				System.out.println(players[i].getName() + " reached the head of a snake; gone down to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==64) {
				players[i].setPosition(60);
				System.out.println(players[i].getName() + " reached the head of a snake; gone down to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==93) {
				players[i].setPosition(68);
				System.out.println(players[i].getName() + " reached the head of a snake; gone down to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==95) {
				players[i].setPosition(24);
				System.out.println(players[i].getName() + " reached the head of a snake; gone down to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==97) {
				players[i].setPosition(76);
				System.out.println(players[i].getName() + " reached the head of a snake; gone down to square " + players[i].getPosition());
			}
			else if(players[i].getPosition()==98) {
				players[i].setPosition(78);
				System.out.println(players[i].getName() + " reached the head of a snake; gone down to square " + players[i].getPosition());
			}
			
			
			}
		}
			
	
		
	}
	

}
