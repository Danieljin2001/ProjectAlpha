package codes;

import java.util.ArrayList;

public abstract class Player {
	
	private GameState state;
	private double MONEY;
	private double BET_AMOUNT = 0; //dynamic
	private String NAME;
	protected Boolean HUMAN;
	
	private ArrayList<Card> HAND = new ArrayList<>();
	protected Deck DECK;
	private int HAND_VALUE = 0;
		
	
	public Player(Deck deck, double startMoney, String name) {
		this.DECK = deck;
		this.MONEY = startMoney;
		this.NAME = name;
		this.state = new StartState(deck);
	}
	
	public void changeState(GameState state) {
		this.state = state;
	}
	
	//AI logic to whether hit, stand, bet, etc.
	//BASICALLY PLAYER LOGIC
	//rename dealer class checkLogic() to play()
	public GameState play() {
		return null;
			
	}
	
	//unfinished
	public void split() {
		if (BET_AMOUNT > 0) {
			
		}
	}
	
	//unfinished
	public void doubleBet() {
		if (BET_AMOUNT > 0 && BET_AMOUNT*2 <= MONEY) {
			BET_AMOUNT = BET_AMOUNT * 2;
		}
	}
	
	public Card hit() {
		Card card = DECK.drawCard();
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
	
	public void clearHand() {
		HAND.clear();
		HAND_VALUE = 0;
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