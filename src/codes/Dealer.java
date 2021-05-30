package codes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;


public class Dealer {

	static int handValue = 0;
	static int x = 0;

	private static ArrayList<Card> dealerHand = new ArrayList<>();
	

    
	public static void main(String []args) throws Exception{
		

	    Deck firstDeck = new Deck(1);   
	    ArrayList<Card> drawnCards = new ArrayList<>();
		
		Hit(drawnCards, firstDeck, x);
		
      }
		
	/**
	 * This method "hits" so it will draw a card from the deck array and will add that card to the drawnCards array. As well as call on the checkLogic function to see what to do next. 
	 *  @param drawnCards cards is an array that holds all the cards that have been drawn and added to the dealers hand.
	 * @param firstDeck is what the deck that is being used is called. I think Daniel made it like this so we can use multiple decks in the future.
	 * @param x is what card in the drawnCards array is being checked/added to the total. (Basically keeping track of which card is added the most recently to the hand)
	 */
	public static void Hit(ArrayList<Card> drawnCards, Deck firstDeck, int x) {
		System.out.println("dealer hit"+ "\n");
		drawnCards.add(firstDeck.drawCard());
		dealerHand.add(firstDeck.drawCard());
		
		
		System.out.println(drawnCards.get(x));

    	if(dealerHand.get(x).getValue().get(0) == 1 && handValue <= 10){
    		handValue += dealerHand.get(x).getValue().get(1);
    		
    	}
    	else
    	{
    		handValue += dealerHand.get(x).getValue().get(0);
    	}
	
        System.out.println("Total is " + handValue + "\n");
		x  += 1;

		checkLogic(dealerHand, firstDeck, x);
		


	}
	
	/**
	 * This method checks the value that is in the dealer's hand and see's if it should hit or hold. Also tells it if it won or not.
	 * @param dealerHand cards is an array that holds all the cards that have been drawn and added to the dealers hand.
	 * @param firstDeck is what the deck that is being used is called. I think Daniel made it like this so we can use multiple decks in the future.
	 * @param x is what card in the drawnCards array is being checked/added to the total. (Basically keeping track of which card is added the most recently to the hand)
	 */
	public static void checkLogic(ArrayList<Card> dealerHand, Deck firstDeck, int x)
	{
		
		if (handValue > 21){
			Lost();

		}
		else if (handValue == 21){
			
			Win();
		}
		else if (handValue <17)
		{
			Hit(dealerHand, firstDeck, x);
		}
		else {
			Hold();
		}
	}

	/** 
	 * this method is to declare when the dealer wins
	 */
	public static void Win (){
		System.out.println("Dealer Wins");
	}
	
	/** 
	 * this method is to declare when the dealer busts
	 */
	public static void Lost (){
		System.out.println("Dealer Loses");
	}
	
	/** 
	 * this method is to declare when the dealer holds
	 */
	public static void Hold (){
		System.out.println("Dealer holds");
	}

	public static int getHandValue() {
		return handValue;
	}
	
}