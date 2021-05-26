package codes;

import java.util.ArrayList;

public class Player {
	private double MONEY = 0;
	private double BET_AMOUNT = 0; //dynamic
	
	
	private ArrayList<Card> HAND = new ArrayList<Card>();
	protected Deck DECK;
		
	/**
	 * Constructor
	 * @param deck (takes in a deck in the constructor parameter)
	 *  
	 */
	public Player(Deck deck, double startMoney, String NAME ) {
		this.DECK = deck;
		this.MONEY = startMoney;
	}
	
		
	/**
	 * This method is used for players to hit a card.
	 */
	public void hit() {
		Card hitCard = DECK.drawCard();
		HAND.add(hitCard);
	}
	
	
	/**
	 * This method is used to clear the players hand (use every time a new round starts or round ends)
	 */
	public void clearHand() {
		HAND.clear();
	}
	
	/**
	 * This method is used to add money to the players account.
	 * @param amount double (amount of money user wants to add)
	 */
	private void addMoney(double amount) {
		MONEY += amount;
	}
	
	public void betMoney(double amount) throws Exception {
		if (amount > MONEY) {
			throw new Exception("Betting amount cannot be greater than the amount of money the player has.");
		}
		
		else {
			BET_AMOUNT = amount;
		} 
	}
	
	public void allIn() {
		BET_AMOUNT = MONEY;
	}
	
	
	
	public void win() {
		MONEY += BET_AMOUNT;
		BET_AMOUNT = 0;
	}
	
	public void lose() {
		MONEY -= BET_AMOUNT;
		BET_AMOUNT = 0;
	}
	
	/**
	 * This method returns an array of the player's hand
	 * @return ArrayList<Card> (returns an array of Card)
	 */
	public ArrayList<Card> getHand(){
		return HAND;
	}
	
	public double getMoney() {
		return MONEY;
	}

}
