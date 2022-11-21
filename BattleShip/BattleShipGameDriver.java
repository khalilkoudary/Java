//-------------------------------------------------------------
// Assignment 4
// Written by: Khalil Koudary
//For COMP 248 EC - Fall 2020
//--------------------------------------------------------------
/* this program is a battleship game against a computer.
 */

import java.util.Scanner;
public class BattleShipGameDriver {

	public static void main(String[] args) {
		BattleShipGame game = new BattleShipGame();
		Scanner keyIn = new Scanner(System.in);
		
		//welcome message
		System.out.println("Hi, let's play Battleship!");
		System.out.println();
		
		int position = 1; 
		int ship = 0;
		
		//asking user to enter the coordinates of their ship, and assigning the coordinates to the array. 
		while (ship<6) {
			System.out.println("Enter the coordinates of your ship #" + position + ":");
			String coordinates = keyIn.next();
			
			//checking if the coordinates are outside of the grid.
			if(coordinates.charAt(0)>'H' || coordinates.charAt(0) > 'h' || coordinates.charAt(1)>'8'|| coordinates.charAt(1)<'1') {
				System.out.println("Sorry coordinates outside the grid. try again.");
				continue; 
			}
			else {
				
				//setting the coordinates in their place on the grid.
				game.Col(coordinates);
				game.Row(coordinates);
				
				//checking if the coordinates are already used
				boolean used = game.check();
				if(used == true) {
					System.out.println("Sorry, coordinates already used. try again");
					continue; 
				}
				else {
					//inserting a ship at the coordinates provided. 
					game.Ship();
					ship++; 
					position++; 
				}
				
				
			}
		}
		
		//asking user to enter the coordinates of their grenade, and assigning the coordinates to the array
		
		int position2=1;
		int grenade = 0; 
		
		while (grenade<4) {
			System.out.println("Enter the coordinates of your grenade #" + position2 + ":");
			String coordinates2 = keyIn.next();
			
			//checking if the coordinates are outside of the grid
			if(coordinates2.charAt(0)>'H' || coordinates2.charAt(0) > 'h' || coordinates2.charAt(1)>'8'|| coordinates2.charAt(1)<'1') {
				System.out.println("Sorry coordinates outside the grid. try again.");
				continue; 
			}
			else {
				
				//setting the coordinates in their place on the grid.
				game.Col(coordinates2);
				game.Row(coordinates2);
				
				//checking if the coordinates are already used
				boolean used = game.check();
				if(used == true) {
					System.out.println("Sorry, coordinates already used. try again");
					continue; 
				}
				else {
					//inserting a grenade at the coordinates provided. 
					game.Grenade();
					grenade++; 
					position2++; 
				}
				
				
			}
		}
		
		//setting the coordinates for the computer's ships
		int i=0; 
		int j=0; 
		while (i<6) {
			game.randomRow();
			game.randomColumn();
			
			//checking if the coordinates have already been used
			boolean used2 = game.check();
			if(used2 ==true) {
				continue;
			}
			else {
				//assigning the coordinates
				game.ComputerShip();
				i++;
			}
		}
		
		//setting the coordinates for the computer's grenades. 
		while(j<4) {
			game.randomRow();
			game.randomColumn();
			
			boolean used2 = game.check();
			if(used2 == true) {
				continue;
			}
			else {
				game.ComputerGrenade();
				j++;
			}
		}
		
		
		System.out.println();
		System.out.println("OK, the computer placed its ships and grenades at random. Let's play.");
		
		
		}
	
	

	}


