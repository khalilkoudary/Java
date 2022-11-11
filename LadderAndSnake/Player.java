// -----------------------------------------------------
// Assignment 1
// Question: Part I and II
// Written by: Khalil Koudary (ID: 40088454)
//Assignment due date: Feb. 8th
// -----------------------------------------------------
/**
 * This class represents a player. Each player has a name, a turn, a dice value, and a position on the Snake and Ladder board. 
 * @author Khalil Koudary
 *
 */

public class Player {
	
	//private attributes
	private String name; 
	private int turn;
	private int dice;
	private int position;
	
	/**
	 * Default constructor, sets all attributes to the null of their types. 
	 */
	
	//default constructor
	public Player() {
		this(" ");
	}
	/**
	 * Constructor with one parameter name. 
	 * Sets the name of the calling object equal to the name in the parameter. 
	 * Sets the other attributes to the zero of their relative types.
	 * @param name the name of the player
	 */
	//constructor with one parameter
	public Player(String name) {
		this.name = name;
		this.turn = 0; 
		this.dice =0;
		this.position=0;
	}
	
	/**
	 * accessor method to return the name of a player.
	 * @return the name of the player
	 */
	//accessor methods
	public String getName() {
		return this.name;
	}
	/**
	 * accessor method to return the turn of a player
	 * @return the turn of the player
	 */
	public int getTurn() {
		return this.turn;
	}
	/**
	 * acessor method to return the dice value of a player
	 * @return the dice value of a player
	 */
	public int getDice() {
		return this.dice;
	}
	/**
	 * accessor method to return the position of a player.
	 * @return the position of a player
	 */
	public int getPosition() {
		return this.position;
	}
	/**
	 * mutator method that sets the turn of the calling player to be equal to the value inside the parameter. 
	 * @param turn the turn of a player
	 */
	//mutator methods
	public void setTurn(int turn) {
		this.turn = turn;
	}
	/**
	 * mutator method that sets the name of the calling player to be equal to the value inside the parameter.
	 * @param name the name of a player
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * mutator method that sets the dice value of the calling player to be equal to the value inside the parameter. 
	 * @param Dice the dice value that a player got
	 */
	public void setDice(int Dice) {
		this.dice = Dice;
	}
	/**
	 * mutator method that sets the position of the calling player to be equal to the value inside the parameter.
	 * @param position the position of a player
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	/**
	 * method that takes in an array of Player objects as a parameter
	 * and outputs the order of the players' turns. 
	 * @param players all the players in the game.
	 */
	//method to determine the order of playing
	public static void determineTurn(Player[] players) {
	        rollPlayers(players);
	        for (int i = 0; i < players.length; i++) {
	            players[i].setTurn(i);
	        }
	        System.out.println("Order of playing will be: " + playerNamesString(players));
	    }
	/**
	 * method that takes in an array of Player objects as a parameter
	 * then gets each player in the array to roll the dice. 
	 * Once the players have rolled the dice, they are sorted depending on the dice value they got. 
	 * The players that got the same dice value, will reroll the dice.
	 * @param players all the players in the game
	 */
    //gets players to roll the dice, sorts players, and then rerolls tied players
	    private static void rollPlayers(Player[] players) {
	        setPlayersDice(players);
	        sort(players);
	        reRollTiedPlayers(players);
	    }
	    /**
	     * method that takes in an array of Player objects as a parameter. 
	     * gets each player to roll the dice and then sets the dice value of each player. 
	     * @param players all the players in the game
	     */
   // each player will flip the dice and get the initial dice value.
	    private static void setPlayersDice(Player[] players) {
	        for (int i = 0; i < players.length; i++) {
	            players[i].setDice(LadderAndSnake.flipDice());
	            System.out.println(players[i].getName() + " got a dice value of " + players[i].getDice());
	        }
	    }
	    /**
	     * method that takes in an array of Player objects as parameter. 
	     * sorts the players depending on the dice value that they got once they flipped the dice. 
	     * @param players all the players in the game
	     */

	    // sorts players from the biggest dice to the smallest
	    private static void sort(Player[] players) {
	        for (int i = 0; i < players.length - 1; i++) {
	            // Find the player with the biggest dice after the current player
	            int maxIdx = i;
	            for (int j = i + 1; j < players.length; j++) {
	                if (players[j].getDice() > players[maxIdx].getDice()) {
	                    maxIdx = j;
	                }
	            }

	            // swap current player with the player with the biggest dice if it was bigger than the current player's
	            if (maxIdx != i) {
	                Player temp = players[maxIdx];
	                players[maxIdx] = players[i];
	                players[i] = temp;
	            }
	        }
	    }
	    /**
	     * method that takes an array of Player objects as parameter. 
	     * rerolls those players who got the same dice value. 
	     * @param players all the players in the game.
	     */

	    private static void reRollTiedPlayers(Player[] players) {
	        for (int i = 1; i < players.length; i++) {
	            int begin = i - 1;
	            // find how many players have the same dice
	            while (i < players.length && players[i].getDice() == players[i - 1].getDice()) {
	                // we'll re-roll those players independently, so the for loop should not go over them again.
	                i++;
	            }
	            int toReRoll = i - begin;
	            if (toReRoll > 1) {
	                Player[] playersToReRoll = copyRange(players, begin, i - 1);
	                System.out.println("Players " + playerNamesString(playersToReRoll) + " tied; rerolling");
	                // repeat the process for each player group that needs to re-roll
	                rollPlayers(playersToReRoll);
	                // The player group has rerolled and sorted itself; override the previous sorting of that group
	                // with the new one.
	                copyTo(playersToReRoll, players, begin);
	            }
	        }
	    }
	    /**
	     * copies the elements from fromIdx to toIdx of the original array to a new array
	     * returns an array of Player objects.
	     * @param original
	     * @param fromIdx
	     * @param toIdx
	     * @return
	     */

	    // copies the elements from [fromIdx to toIdx] of the original array to a new array
	    private static Player[] copyRange(Player[] original, int fromIdx, int toIdx) {
	        int newLength = toIdx - fromIdx + 1;
	        Player[] copy = new Player[newLength];
	        copyRangeInto(original, fromIdx, toIdx, copy, 0);
	        return copy;
	    }
	    /**
	     * copies the entire origianl array into the recepient array starting from recipientStartIdx.
	     * @param original
	     * @param recipient
	     * @param recipientStartIdx
	     */

	    // copies the entire original array into the recipient array starting from recipientStartIdx
	    private static void copyTo(Player[] original, Player[] recipient, int recipientStartIdx) {
	        copyRangeInto(original, 0, original.length - 1, recipient, recipientStartIdx);
	    }
	    /**
	     * copies the elements from copyStartIdx to copyEndIdx of the original array to the 
	     * recepient array starting from position recepientStartIdx.
	     * @param original
	     * @param copyStartIdx
	     * @param copyEndIdx
	     * @param recipient
	     * @param recipientStartIdx
	     */

	    // copies the elements from [copyStartIdx to copyEndIdx] of the original array to the
	    // recipient array starting from position recipientStartIdx.
	    private static void copyRangeInto(Player[] original, int copyStartIdx, int copyEndIdx,
	                                      Player[] recipient, int recipientStartIdx) {
	        for (int i = copyStartIdx; i <= copyEndIdx; i++) {
	            recipient[i - copyStartIdx + recipientStartIdx] = original[i];
	        }
	    }
	    /**
	     * returns a string that contains all the given players' names
	     * @param players all the players in the game
	     * @return name of players
	     */

	    // returns a string that contains all the given players' names
	    private static String playerNamesString(Player[] players) {
	        String s = "[";
	        for (int i = 0; i < players.length; i++) {
	            s += players[i].getName();
	            if (i != players.length - 1) {
	                s += ", ";
	            }
	        }
	        s += "]";
	        return s;
	    }

		}
	
		
		
		



