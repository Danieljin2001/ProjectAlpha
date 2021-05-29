package codes;

import java.util.ArrayList;

public class Test {
	public static void main(String []args) throws Exception{
	    Deck firstDeck = new Deck(1);   
		Dealer dealer  = new Dealer(firstDeck);
		dealer.Hit();
       
	}
} 