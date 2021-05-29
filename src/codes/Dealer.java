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
	
	
	public  void Hit() {
		System.out.println("dealer hit"+ "\n");

		dealerHand.add(DECK.drawCard());
		int x = dealerHand.size() - 1;
		
		System.out.println(dealerHand);
    	if(dealerHand.get(x).getValue().get(0) == 1 && handValue <= 10){
    		handValue += dealerHand.get(x).getValue().get(1);
    		
    	}
    	else
    	{
    		handValue += dealerHand.get(x).getValue().get(0);
    	}
	
        System.out.println("Total is " + handValue + "\n");

		checkLogic();
		

	}
	
	public  void checkLogic()
	{
		
		if (handValue > 21){
			Lost();

		}
		else if (handValue == 21){
			
			Win();
		}
		else if (handValue <17)
		{
			Hit();
		}
		
		else if(handValue >= 17 && handValue <21) {
			Hold();
		}
		else
		{
			
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
	
	
}