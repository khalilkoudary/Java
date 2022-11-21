//-------------------------------------------------------------
// Assignment 4
// Written by: Khalil Koudary
//For COMP 248 EC - Fall 2020
//--------------------------------------------------------------
/* this program is a battleship game against a computer.
 */
public class BattleShipGame {
	//declaring attributes
	private char grid[][] = new char[8][8];
	private int row; 
	private int column; 
	private int play1; 
	private int play2;
	
	//constructor with no parameters. 
	public BattleShipGame() {
		row = 0; 
		column =0; 
		for (int j =0; j<grid.length ; j++) {
			for (int i =0; i<grid[j].length; i++) {
				grid[i][j]= '_';
			}
		}
	}
	
	//constructor that takes one array parameter. 
	public BattleShipGame(BattleShipGame g) {
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j< grid[i].length;j++) {
				this.grid[i][j]=g.grid[i][j];
			}
		}
		
	}
	
	//assigning column for human player
	public int Col(String c) {
		if(c.toLowerCase().charAt(0)=='a')
			column =0; 
		else if(c.toLowerCase().charAt(0)=='b')
			column =1; 
		else if(c.toLowerCase().charAt(0)== 'c') {
			column = 2; 
		}
		else if(c.toLowerCase().charAt(0)=='d') {
			column =3; 
		}
		else if(c.toLowerCase().charAt(0)=='e')
			column =4;
		else if(c.toLowerCase().charAt(0)=='f')
			column =5; 
		else if(c.toLowerCase().charAt(0)=='g') {
			column =6; 
		}
		else if(c.toLowerCase().charAt(0)=='h')
			column =7; 
		return column; 
	}
	
	//assigning row for human player
	public int Row(String s) {
		if(s.toLowerCase().charAt(1)=='1')
			row =0; 
		else if(s.toLowerCase().charAt(1)=='2') {
			row =1;
		}
		else if(s.toLowerCase().charAt(1)=='3') {
			row =2; 
		}
		else if(s.toLowerCase().charAt(1)=='4')
			row =3; 
		else if(s.toLowerCase().charAt(1)=='5') {
			row =4;
		}
		else if(s.toLowerCase().charAt(1)=='6') {
			row =5; 
		}
		else if(s.toLowerCase().charAt(1)=='7') {
			row =6;
		}
		else if(s.toLowerCase().charAt(1)=='8') {
			row =7;
		}
		return row; 
		
	}
	
	//assigning random row for computer
	public int randomRow() {
		this.row = (int)(Math.random()*((8-1)+1)-1);
		return row;
	}
	
	//assigning random column for computer
	public int randomColumn() {
		this.column = (int)(Math.random()*((8-1)+1)-1);
		return column; 
	}
	
	//placing the human ship on the grid
	public void Ship() {
		grid[this.column][this.row]='s';
	}
	
	//placing the computer ship on the grid
	public void ComputerShip() {
		grid[this.column][this.row]='S';
	}
	
	//placing the human grenade on the grid
	public void Grenade() {
		grid[this.column][this.row]='g';
	}
	
	//placing the computer grenade on the grid
	public void ComputerGrenade() {
		grid[this.column][this.row]='G';
	}
	
	//checking if the coordinates have been used before. 
	public boolean check() {
		return grid[this.column][this.row]=='G' || grid[this.column][this.row]=='g'|| grid[this.column][this.row]=='S'|| grid[this.column][this.row]=='s';
	}
	
	
	}
	


