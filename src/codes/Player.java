package codes;

import java.util.ArrayList;

public class Player {
	private GameState state;
	private double MONEY;
	private double BET_AMOUNT = 0; //dynamic
	private String NAME;
	private Boolean HUMAN = false;
	
	private ArrayList<Card> HAND = new ArrayList<>();
	protected Deck DECK;
	private int HAND_VALUE = 0;
		
	/**
	 * Constructor
	 * @param deck (takes in a deck in the constructor parameter)
	 *  
	 */
	public Player(Deck deck, double startMoney, String name) {
		this.DECK = deck;
		this.MONEY = startMoney;
		this.NAME = name;
		this.state = new StartState(deck);
	}

	public void changeState(GameState state) {
		this.state = state;
	}

	/**
	 * This method is used for players to hit a card.
	 */
	public Card hit() {
		Card card = DECK.drawCard();
		/*
		try {
			Card Hard = state.hit();
		} 
		catch (Exception e) {
			System.out.println("It is not your turn!: " + e);
		}
		*/
		
		HAND.add(card);
		HAND_VALUE += (card.getValue()).get(0); //note that every Ace is initially calculated with value = 1
		changeAceValue();
		return card;
	}
	
	private void changeAceValue() {
		boolean hasAce = false;
		int valueWithoutAce = 0;
		int numberOfOtherAces = -1;
		//checking if the hand has an Ace
		for (Card card : HAND) {
			if ((card.getName()).equals("Ace")) {
				hasAce = true;
				numberOfOtherAces++;
			}
			else {
				valueWithoutAce += card.getValue().get(0);
			}
		}
		
		int valueOfAce = HAND_VALUE - valueWithoutAce - numberOfOtherAces;
		
		if (hasAce) {
			//first try setting the Ace to 11
			if ((HAND_VALUE - valueOfAce + 11) <= 21) {
				HAND_VALUE = HAND_VALUE - valueOfAce + 11; //setting one of the Ace(s) to 11
			}
			else if((HAND_VALUE - valueOfAce + 1) <= 21) {
				HAND_VALUE = HAND_VALUE - valueOfAce + 1; //setting one of the Ace(s) to 1
			}
			else {
				HAND_VALUE = HAND_VALUE - valueOfAce + 1; //set the Ace to 1 default if its over 21
			}
		}
		
	}

	/**
	 * This method is used to clear the players hand (use every time a new round starts or round ends)
	 */
	public void clearHand() {
		HAND.clear();
		HAND_VALUE = 0;
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
	
	public String getNAME() {
		return NAME;
	}

	public GameState getState() {
		return state;
	}

	public Boolean isHUMAN() {
		return HUMAN;
	}
	
	public int getHandValue() {
		return HAND_VALUE;
	}

}
