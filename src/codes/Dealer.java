package codes;

import java.util.ArrayList;

public class Dealer {
	
	private Deck DECK;
	private  ArrayList<Card> dealerHand = new ArrayList<Card>();
	
	private int handValue = 0;
	
	public  Dealer(Deck deck)
	{
		this.DECK = deck;
	}
	
	/*
	 * Draws a card from the deck and adds it to the dealers hand as well as calculates the total sum in the players hand with handValue. 
	 */
	public Card Hit() {
		//System.out.println("dealer hit"+ "\n");
		Card card = DECK.drawCard();
		dealerHand.add(card);
		handValue += (card.getValue()).get(0);

		changeAceValue();
		
		return card;

		

	}
	
	/*
	 * Figures out what to do next basically
	 */
	public void checkLogic()
	{
		boolean hold = false;
		while(hold == false) {
		
		if (handValue > 21){
			Lost();
			hold = true;

		}
		else if (handValue == 21){
			
			Win();
			hold = true;
		}
		else if (handValue <17)
		{
			System.out.println("You hit: " + Hit());
			System.out.println("Your hand: " + getHand());
			System.out.println("Your hand total value: " + getHandValue());
		}
		
		else if(handValue >= 17 && handValue <21) {
			Hold();
			hold = true;
		}
		else
		{
			
		}
		
	}
}

	/** 
	 * this method is to declare when the dealer wins
	 */
	public  void Win (){
		System.out.println("Dealer Wins");
   
	}
	
	/** 
	 * this method is to declare when the dealer busts
	 */
	public  void Lost (){
		System.out.println("Dealer Loses");
    
	}
	
	/** 
	 * this method is to declare when the dealer holds
	 */
	public  void Hold (){
		System.out.println("Dealer holds");
    
	} 
	
	public void clearHand(){	
		dealerHand.removeAll(dealerHand);
		handValue = 0;
	}
	
	private void changeAceValue() {
		boolean hasAce = false;
		int valueWithoutAce = 0;
		int numberOfOtherAces = -1;
		//checking if the hand has an Ace
		for (Card card : dealerHand) {
			if ((card.getName()).equals("Ace")) {
				hasAce = true;
				numberOfOtherAces++;
			}
			else {
				valueWithoutAce += card.getValue().get(0);
			}
		}
		
		int valueOfAce = handValue - valueWithoutAce - numberOfOtherAces;
		
		if (hasAce) {
			//first try setting the Ace to 11
			if ((handValue - valueOfAce + 11) <= 21) {
				handValue = handValue - valueOfAce + 11; //setting one of the Ace(s) to 11
			}
			else if((handValue - valueOfAce + 1) <= 21) {
				handValue = handValue - valueOfAce + 1; //setting one of the Ace(s) to 1
			}
			else {
				handValue = handValue - valueOfAce + 1; //set the Ace to 1 default if its over 21
			}
		}
		
	}
	
	public int getHandValue() {
		return handValue;
	}
	
	public ArrayList<Card> getHand(){
		return dealerHand;
	}
	
}