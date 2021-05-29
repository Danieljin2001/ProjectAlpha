package codes;

import java.util.Scanner;

public class Menu {
	private int PLAYER_NUMBER;
	private int DECK_NUMBER;
	private int MONEY;
	private String NAME;
	
	/**
	 * Asks the user how many players will be playing for the game. It has a limit of 7 players
	 */
	public void askPlayerNumber() {
		boolean playerDone = false;
		while (!playerDone) {
			try {
				System.out.print("How many players are playing?");
				Scanner playerNumber = new Scanner(System.in);
				PLAYER_NUMBER = playerNumber.nextInt();
				if (PLAYER_NUMBER > 0 && PLAYER_NUMBER < 8) {
					System.out.print("We have " + PLAYER_NUMBER + " player(s) with us today\n");
					playerDone = true;
				}
				else
					throw new ArithmeticException ("Please enter a positive integar between 1-7\n");
			}
			catch(Exception e) {
				System.out.print("Please enter a positive integar between 1-7\n");
			}
		}
	}
	/**
	 * Asks the user for how many decks will be used for the game of blackjack
	 */
	public void askDeckNumber() {
		boolean deckDone = false;
		while (!deckDone) {
			try {
				System.out.print("How many decks are we using?");
				Scanner deckNumber = new Scanner(System.in);
				DECK_NUMBER = deckNumber.nextInt();
				if (DECK_NUMBER > 0 && DECK_NUMBER != 3 && DECK_NUMBER < 9) {
					System.out.print("The number of decks we are using is " + DECK_NUMBER + "\n");
					deckDone = true;	
				}
				else 
					throw new ArithmeticException ("Please enter a positive integar between 1-8 with an exception of 3");
			}
			catch(Exception e) {
				System.out.print("Please enter a positive integar between 1-8 with an exception of 3\n");
			}
		}
	}
	/**
	 * Asks the user how much money they will be using for the game 
	 */
	public void askMoney() {
		boolean moneyDone = false;
		while (!moneyDone) {
			try {
				System.out.print(NAME + ". How much money are you going to be betting?");
				Scanner moneyAmount = new Scanner(System.in);
				MONEY = moneyAmount.nextInt();
				if (MONEY > 0) {
					System.out.print("You will be playing with $" + MONEY + " today\n");
					moneyDone = true;
				}
				else 
					throw new ArithmeticException ("Please enter a positive integar");
			}
			catch(Exception e) {
				System.out.print("Please enter a positive integar");
		}
		}
	}
	/**
	 * Asks the user for the player's name
	 */
	public void askName() {
		Scanner playerName = new Scanner(System.in);
		System.out.print("What is your name?");
		NAME = playerName.next();
		System.out.print("Nice to meet you " + NAME + "\n");
	}
	/**
	 * Getter method for the name
	 * @return name of the player
	 */
	public String getNAME() {
		return NAME;
	}
	/**
	 * Getter method for the number of players in the game
	 * @return Number of players
	 */
	public int getPLAYER_NUMBER() {
		return PLAYER_NUMBER;
	}
	/**
	 * Getter method for the number of decks used in the game
	 * @return Number of decks
	 */
	public int getDECK_NUMBER() {
		return DECK_NUMBER;
	}
	/**
	 * Getter method for the amount of money that each players are using for the game
	 * @return Amount of money
	 */
	public int getMONEY() {
		return MONEY;
	}

}
